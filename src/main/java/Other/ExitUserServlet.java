package Other;

import User.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    User exit from session
 */
@WebServlet("/exit")
public class ExitUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserModel userNull = new UserModel(0, "", "", "", "", "");
        req.getSession().setAttribute("user", userNull);
        resp.sendRedirect("/login");
    }
}
