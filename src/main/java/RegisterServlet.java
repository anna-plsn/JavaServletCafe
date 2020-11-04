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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = "";
        req.setAttribute("error", error);
    req.getRequestDispatcher("/register.ftl" ).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        String sql = "INSERT INTO user (name, surname, email, password, image) VALUES( ?,?,?,?,?)";
        String sql2 = "Select email from user where email=?";
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserModel user = new UserModel(0, name, surname, email, password,"");
        String error = "";
        Boolean existEmail = false;


        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql2)) {

            statement.setString(1, user.getEmail());
            ResultSet resultSet = statement.executeQuery();
            String s = null;
            if(resultSet.next()){
                s = resultSet.getString("email");
            }

            if (s != null){
                existEmail = true;
            }

        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        if (!existEmail) {
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {


                statement.setString(1, user.name);
                statement.setString(2, user.surname);
                statement.setString(3, user.email);
                statement.setString(4, user.password);
                statement.setString(5, "default-user-avatar.jpg");
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            resp.sendRedirect("/login");
        }
        else {
            error = "Такой email уже существует";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/register.ftl").forward(req, resp);
        }
    }
}
