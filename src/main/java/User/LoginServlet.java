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

/*
    Logging in for user
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //        show error about wrong email or password
        String error = "";
        req.setAttribute("error", error);
        req.getRequestDispatcher("/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        //        show error about wrong email or password
        String error = "";

        String email = req.getParameter("email");
        String password = req.getParameter("password");

//            logging in for user
        String sql = "SELECT id, name, surname, image FROM user WHERE email = '" + email + "' AND password = '" + password + "'";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String image = resultSet.getString("image");
                UserModel user = new UserModel(id, name, surname, email, "", image);
                req.getSession().setAttribute("user", user);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        //        show error about wrong email or password
        UserModel user = (UserModel) req.getSession().getAttribute("user");
        if (user == null) {
            error = "Пароль или логин введены неверно, или вы не зарегестрированы";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/login.ftl").forward(req, resp);
        }

        resp.sendRedirect("/profile");
    }
}

