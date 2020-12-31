package Cart;

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
    Show cart for user
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        //        check for user session
        UserModel user = (UserModel) req.getSession().getAttribute("user");
        if (user == null || user.getName() == "") {
            resp.sendRedirect("/catalog");
        }

//        info for user about empty cart
        String empty_cart = "";

//        Show cart for user
        String query = "select user_order.id_product, product.name, product.price, sum(user_order.quantity) as sum from product left join " +
                "user_order on user_order.id_product = product.id where user_order.id_user='" + user.getId() + "' and user_order.paid='0' group by product.id;";

        List<CartModel> cartModels = new ArrayList<>();

        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
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

//        info for user about empty cart
        if (cartModels.isEmpty()) {
            empty_cart = "Your shopping cart is empty";
        }
        req.setAttribute("empty_cart", empty_cart);

        req.getRequestDispatcher("/cart.ftl").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        info for user about empty cart
        String empty_cart = "";
        req.setAttribute("empty_cart", empty_cart);
        req.getRequestDispatcher("/cart.ftl").forward(req, resp);
    }
}
