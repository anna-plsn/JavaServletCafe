import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/register.ftl" ).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        String sql = "INSERT INTO user (name) VALUES( ? )";
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        UserModel user = new UserModel(0, name);

        Cookie cookieName = new Cookie("name", user.getName());
        resp.addCookie(cookieName);

        req.getSession().setAttribute("user", user);
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setString(1, user.name);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        resp.sendRedirect("/db");
    }
}
