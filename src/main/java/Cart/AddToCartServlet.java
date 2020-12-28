package Cart;

import Product.ProductModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/addToCart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        int id = Integer.parseInt(req.getParameter("id"));

//        String sql = "SELECT name FROM product WHERE id = '" + id + "'";
//
        List<ProductModel> productModels = new ArrayList<>();
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//
        productModels.add(new ProductModel(id, "", "",0));

//            }
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
        req.getSession().setAttribute("productModel", productModels);

        RequestDispatcher rd = req.getRequestDispatcher("/User.ProfileServlet");
        rd.forward(req, resp);

        String idSession = (String) req.getSession().getAttribute("productModel");


        System.out.println("add"+idSession);
        resp.sendRedirect("/profile");
    }
}

