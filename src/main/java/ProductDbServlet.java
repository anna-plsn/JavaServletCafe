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

@WebServlet(urlPatterns = "/productDB")
public class ProductDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        AdminModel adminModel = (AdminModel) req.getSession().getAttribute("adminModel");

        if (adminModel == null || adminModel.getName()==""){
            resp.sendRedirect("/");
        }

        String query = "SELECT * FROM product";

        List<ProductModel> productModels = new ArrayList<>();

        try(Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String s = resultSet.getString(2);
                int id = resultSet.getInt("id");
                String image = resultSet.getString(3);
                productModels.add(new ProductModel(id, s, image));
            }
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        req.setAttribute("products", productModels);
        req.getRequestDispatcher("/productDB.ftl").forward(req, resp);

    }
}
