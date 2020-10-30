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

@WebServlet(urlPatterns = "/db")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        String query = "SELECT * FROM user";

        List<UserModel> userModels = new ArrayList<>();

        try(Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String s = resultSet.getString(2);
                int id = resultSet.getInt("id");
                userModels.add(new UserModel(id, s));
            }
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        req.setAttribute("users", userModels);
        req.getRequestDispatcher("/index.ftl").forward(req, resp);

    }
}
