package User;

import Cart.CartModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        String empty_paid = "";
        UserModel user = (UserModel) req.getSession().getAttribute("user");
        if (user == null || user.getName()=="") {
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("user", user);
        }

        String query = "select user_order.id_product, product.name, product.price, sum(user_order.quantity) as sum from product left join " +
                "user_order on user_order.id_product = product.id where user_order.id_user='"+user.getId()+"' and user_order.paid='1' group by product.id;";

        List<CartModel> cartModels = new ArrayList<>();

        try(Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id_product = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                int quantity = resultSet.getInt(4);
                cartModels.add(new CartModel(id_product ,name, price, quantity));
            }
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        if (cartModels.isEmpty()) {
            empty_paid = "Your shopping cart is empty";
        }
        req.setAttribute("empty_paid", empty_paid);
        req.setAttribute("carts", cartModels);
        req.getRequestDispatcher("/profile.ftl").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empty_paid = "";
        req.setAttribute("empty_paid", empty_paid);
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        UserModel user = (UserModel) req.getSession().getAttribute("user");
        if (user == null || user.getName()=="") {
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("user", user);
        }

        String query = "select user_order.id_product, product.name, product.price, sum(user_order.quantity) as sum from product left join " +
                "user_order on user_order.id_product = product.id where user_order.id_user='"+user.getId()+"' and user_order.paid='1' group by product.id;";

        List<CartModel> cartModels = new ArrayList<>();

        try(Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id_product = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                int quantity = resultSet.getInt(4);
                cartModels.add(new CartModel(id_product ,name, price, quantity));
            }
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        if (cartModels.isEmpty()) {
            empty_paid = "You don't have any purchases";
        }
        req.setAttribute("empty_paid", empty_paid);
        req.setAttribute("carts", cartModels);
        req.getRequestDispatcher("/profile.ftl").forward(req, resp);

    }
}
