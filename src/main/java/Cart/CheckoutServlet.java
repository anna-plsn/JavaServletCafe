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
import java.sql.SQLException;
/*
    Buy products from cart
 */
@WebServlet(urlPatterns = "/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        UserModel user = (UserModel) req.getSession().getAttribute("user");

        String sql = "UPDATE user_order SET paid = '1' WHERE id_user = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, Integer.valueOf(user.getId()));
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        resp.sendRedirect("/catalog");
    }
}
