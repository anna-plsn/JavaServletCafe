package User;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = "";
        req.setAttribute("error", error);
        req.getRequestDispatcher("/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String sql = "SELECT name, surname, image FROM user WHERE email = '"+email+"' AND password = '"+password+"'";

        String error = "";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String image = resultSet.getString("image");
                    UserModel user = new UserModel(0, name, surname, email, "", image);
                    req.getSession().setAttribute("user", user);
                }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        UserModel user = (UserModel) req.getSession().getAttribute("user");
        if (user==null){
            error = "Пароль или логин введены неверно, или вы не зарегестрированы";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/login.ftl").forward(req, resp);
        }

//        Cookie cookieName = new Cookie("name", userModel.getName());
//        resp.addCookie(cookieName);
//        req.getRequestDispatcher("/login.ftl").forward(req, resp);
        resp.sendRedirect("/profile");

    }
}

