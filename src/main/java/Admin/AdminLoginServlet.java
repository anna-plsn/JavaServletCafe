package Admin;

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

@WebServlet("/qwer/loginAdmin")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = "";
        req.setAttribute("error", error);
        req.getRequestDispatcher("/loginAdmin.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String sql = "SELECT id FROM admin WHERE name = '"+name+"' AND password = '"+password+"'";

        String error = "";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                AdminModel adminModel = new AdminModel(id,name);
                req.getSession().setAttribute("adminModel", adminModel);

            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        AdminModel adminModel = (AdminModel) req.getSession().getAttribute("adminModel");
        if (adminModel.getId()==null){
            error = "Пароль или логин введены неверно, или вы не admin";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/loginAdmin.ftl").forward(req, resp);
        }

//        Cookie cookieName = new Cookie("name", userModel.getName());
//        resp.addCookie(cookieName);
//        req.getRequestDispatcher("/login.ftl").forward(req, resp);
        resp.sendRedirect("/db");

    }
}

