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

@WebServlet("/addProduct")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AdminModel adminModel = (AdminModel) req.getSession().getAttribute("adminModel");
        if (adminModel == null || adminModel.getName()==""){
            resp.sendRedirect("/");
        }

        String error = "";
        req.setAttribute("error", error);
        req.getRequestDispatcher("/addProduct.ftl" ).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        String sql = "INSERT INTO product (name,image) VALUES(?,?)";
        String sql2 = "Select name from user where name=?";

        String uploadDir = "/home/anna/JavaServletExample/image/";
        Part file = req.getPart("file");

        String images = "/home/anna/JavaServletExample/image/potato.png";
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

        String name = req.getParameter("name");
        ProductModel productModel = new ProductModel(0, name, images);
        String error = "";
        Boolean existName = false;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql2)) {

            statement.setString(1, productModel.getName());
            ResultSet resultSet = statement.executeQuery();
            String s = null;
            if(resultSet.next()){
                s = resultSet.getString("name");
            }

            if (s != null){
                existName = true;
            }

        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        if (!existName) {
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {


                statement.setString(1, productModel.name);
                statement.setString(2,productModel.image);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            resp.sendRedirect("/productDB");
        }
        else {
            error = "Такой продукт уже существует";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/addProduct.ftl").forward(req, resp);
        }
    }
}
