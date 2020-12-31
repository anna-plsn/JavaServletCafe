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
    Paid products for specific user
 */
@WebServlet(urlPatterns = ("/tableOrderDB"))
public class OrderDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        check for admin session
        AdminModel adminModel = (AdminModel) req.getSession().getAttribute("adminModel");
        if (adminModel == null || adminModel.getName()==""){
            resp.sendRedirect("/");
        }
        req.getRequestDispatcher("/orderDB.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

//        list of users for dropdown list
        List<UserModel> userModels = (List<UserModel>) req.getSession().getAttribute("users");
        req.setAttribute("users", userModels);

//        table of paid products for specific user
        int id_user = Integer.parseInt(req.getParameter("id"));
        String sql = "select user_order.id_product, product.name, product.price, sum(user_order.quantity) as sum from product left join " +
                "user_order on user_order.id_product = product.id where user_order.id_user='"+id_user+"' and user_order.paid='1' group by product.id;";

        List<CartModel> cartModels = new ArrayList<>();

        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id_product = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                int quantity = resultSet.getInt(4);
                cartModels.add(new CartModel(id_product, name, price, quantity));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        req.setAttribute("carts", cartModels);
        req.getRequestDispatcher("/orderDB.ftl").forward(req, resp);
    }
}
