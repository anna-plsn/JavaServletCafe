import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserModel user = (UserModel) req.getSession().getAttribute("user");
//        req.setAttribute("user", user);
        Cookie[] cookies = req.getCookies();
        UserModel user = new UserModel();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("name")){
                user.name = cookie.getValue();
            }
        }
        req.getRequestDispatcher("/profile.ftl").forward(req,resp);
    }
}
