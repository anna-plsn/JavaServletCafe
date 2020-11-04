import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserModel user = (UserModel) req.getSession().getAttribute("user");
        if (user == null || user.getName()=="") {
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("user", user);
        }





//        Cookie[] cookies = req.getCookies();
//
//        for (Cookie cookie: cookies) {
//            if (cookie.getName().equals("name")){
//                user.name = cookie.getValue();
//            }
//        }

        req.getRequestDispatcher("/profile.ftl").forward(req, resp);
    }
}
