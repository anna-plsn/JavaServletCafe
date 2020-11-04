import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/img")
public class ImgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String UPLOAD_DIR = "/home/anna/JavaServletExample/image";
        String filename = req.getParameter("filename");

        resp.setContentType("image/png");
        IOUtils.copyLarge(
                new FileInputStream(UPLOAD_DIR + File.separator + filename),
                resp.getOutputStream()
        );
    }
}
