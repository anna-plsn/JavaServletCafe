package Admin;

import Cart.CartModel;
import User.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
    List of users for dropdown list
 */
@WebServlet(urlPatterns = ("/orderDB"))
public class UserOrderDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        //        check for admin session
        AdminModel adminModel = (AdminModel) req.getSession().getAttribute("adminModel");
        if (adminModel == null || adminModel.getName() == "") {
            resp.sendRedirect("/");
        }

//        list of users for dropdown list and session
        String sql = "select id, name, surname, email from user;";

        List<UserModel> userModels = new ArrayList<>();

        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                String email = resultSet.getString(4);
                userModels.add(new UserModel(id, name, surname, email, "", ""));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        req.setAttribute("users", userModels);
        req.getSession().setAttribute("users", userModels);

//        prevent error of null cartModel
        List<CartModel> cartModels = new ArrayList<>();
        req.setAttribute("carts", cartModels);

        req.getRequestDispatcher("/orderDB.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/orderDB.ftl").forward(req, resp);
    }
}
