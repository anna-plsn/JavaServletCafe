package User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserModel user = (UserModel) req.getSession().getAttribute("user");
        if (user == null || user.getName()=="") {
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("user", user);
        }

//        List<Product.ProductModel> productModels = (List<Product.ProductModel>) req.getSession().getAttribute("productModel");
//        System.out.println(productModels);
//        req.setAttribute("id",productModels);


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
