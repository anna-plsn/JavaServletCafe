package Product;

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
    Show all products for admin
 */
@WebServlet(urlPatterns = "/productDB")
public class ProductDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        //        check for admin session
        AdminModel adminModel = (AdminModel) req.getSession().getAttribute("adminModel");
        if (adminModel == null || adminModel.getName() == "") {
            resp.sendRedirect("/");
        }

//        show all products for admin
        String query = "SELECT * FROM product";

        List<ProductModel> productModels = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String s = resultSet.getString(2);
                int id = resultSet.getInt("id");
                String image = resultSet.getString(3);
                int price = resultSet.getInt(4);
                productModels.add(new ProductModel(id, s, image, price));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        req.setAttribute("products", productModels);
        req.getRequestDispatcher("/productDB.ftl").forward(req, resp);
    }
}
