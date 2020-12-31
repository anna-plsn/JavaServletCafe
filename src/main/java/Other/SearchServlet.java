package Other;

import User.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
    Not in use
    Search string in db
 */
@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        String string = req.getParameter("name");
        byte bytes[] = string.getBytes("UTF-8");
        String value = new String(bytes, "UTF-8");

//        search string in db
        String sql = "SELECT name FROM user WHERE name = '" + value + "'";
        List<UserModel> userModels = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                userModels.add(new UserModel(0, name, "", "", "", ""));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        req.setAttribute("names", userModels);
        req.getRequestDispatcher("/search.ftl").forward(req, resp);

    }
}
