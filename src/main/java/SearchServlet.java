
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        String par = req.getParameter("name");
        byte bytes[] = par.getBytes("UTF-8");
        String value = new String(bytes, "UTF-8");
        String sql = "SELECT name FROM user WHERE name = '"+value+"'";
        System.out.println(value);
        List<UserModel> nameModels = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                nameModels.add(new UserModel(0,name));
            }

        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        req.setAttribute("names", nameModels);
        req.getRequestDispatcher("/search.ftl").forward(req, resp);

    }
}
