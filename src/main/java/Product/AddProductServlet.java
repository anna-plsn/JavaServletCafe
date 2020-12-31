package Product;

import Admin.AdminModel;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/*
    Adding product and image for admin
 */
@WebServlet("/addProduct")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        check for admin session
        AdminModel adminModel = (AdminModel) req.getSession().getAttribute("adminModel");
        if (adminModel == null || adminModel.getName() == "") {
            resp.sendRedirect("/");
        }

        //        show error about existing product
        String error = "";
        req.setAttribute("error", error);
        req.getRequestDispatcher("/addProduct.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        //        show error about existing product
        Boolean existName = false;
        String error = "";

//        standard image
        String images = "/home/anna/JavaServletExample/image/potato.png";

//        upload image
        String uploadDir = "/home/anna/JavaServletExample/image/";
        Part file = req.getPart("file");
        images =
                UUID.randomUUID().toString() +
                        "-" +
                        file.getSubmittedFileName();

        IOUtils.copyLarge(
                file.getInputStream(),
                new FileOutputStream(uploadDir +
                        images
                )
        );

        req.setCharacterEncoding("UTF-8");

//        add product for admin
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        ProductModel productModel = new ProductModel(0, name, images, price);

        String sql2 = "Select name from product where name=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql2)) {

            statement.setString(1, productModel.getName());
            ResultSet resultSet = statement.executeQuery();
            String s = null;
            if (resultSet.next()) {
                s = resultSet.getString("name");
            }
            if (s != null) {
                existName = true;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        //        show error about existing product
        if (!existName) {

//            add new product to db
            String sql = "INSERT INTO product (name,image,price) VALUES(?,?,?)";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, productModel.name);
                statement.setString(2, productModel.image);
                statement.setInt(3, productModel.price);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            resp.sendRedirect("/productDB");
        } else {
            error = "Такой продукт уже существует";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/addProduct.ftl").forward(req, resp);
        }
    }
}
