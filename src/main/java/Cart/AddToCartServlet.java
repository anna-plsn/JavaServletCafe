package Cart;

import Product.ProductModel;
import User.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/addToCart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        int id_product = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        UserModel user = (UserModel) req.getSession().getAttribute("user");
        if (user == null || user.getName()=="") {
            resp.sendRedirect("/catalog");
        }

        String sql = "insert into user_order (id_product, id_user,quantity, paid) values (?,?,?,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setInt(1, id_product);
            statement.setInt(2, user.getId());
            statement.setInt(3, quantity);
            statement.setString(4, "0");
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        resp.sendRedirect("/?msg=Add to cart");
    }
}

