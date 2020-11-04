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

@WebServlet("/main")
public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        String query = "SELECT * FROM user";

        try(Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String s = resultSet.getString(2);
                System.out.println(s);
            }
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        String sql = "INSERT INTO user (name) VALUES( ? )";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            UserModel user = new UserModel(0, "Алексей", "","","", "");

            statement.setString(1, user.name);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        System.out.println(req.getParameterMap());
        req.getRequestDispatcher("/head.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

