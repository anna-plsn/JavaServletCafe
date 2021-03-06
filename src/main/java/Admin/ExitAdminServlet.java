package Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    Admin exit from session
 */
@WebServlet("/exitAdmin")
public class ExitAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminModel adminNull = new AdminModel(0, "");
        req.getSession().setAttribute("adminModel", adminNull);
        resp.sendRedirect("/");
    }
}

