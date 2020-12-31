package User;

import Admin.AdminModel;

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
    Show users for admin
 */
@WebServlet(urlPatterns = "/db")
public class UserDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        //        check for admin session
        AdminModel adminModel = (AdminModel) req.getSession().getAttribute("adminModel");
        if (adminModel == null || adminModel.getName() == "") {
            resp.sendRedirect("/");
        }

//       show users for admin
        String query = "SELECT * FROM user";

        List<UserModel> userModels = new ArrayList<>();

        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String s = resultSet.getString(2);
                int id = resultSet.getInt("id");
                String surname = resultSet.getString(3);
                String email = resultSet.getString(4);
                String password = resultSet.getString(5);
                String image = resultSet.getString("image");
                userModels.add(new UserModel(id, s, surname, email, password, image));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        req.setAttribute("users", userModels);
        req.getRequestDispatcher("/index.ftl").forward(req, resp);
    }
}
