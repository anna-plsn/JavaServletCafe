package Other;

import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/img")
public class ImgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String UPLOAD_DIR = "/home/anna/JavaServletExample/image";
        String filename = req.getParameter("filename");

        int x = 0,y=0;
        BufferedImage originalImage = ImageIO.read(new File(UPLOAD_DIR + File.separator + filename));
        if (originalImage.getWidth()>=originalImage.getHeight()){
            x = (originalImage.getWidth()-originalImage.getHeight())/2;
        }else {
            y = (originalImage.getHeight()-originalImage.getWidth())/2;
        }

        BufferedImage subImage = originalImage.getSubimage(x, y, originalImage.getWidth()-2*x, originalImage.getHeight()-2*y);


        File outputFile = new File(UPLOAD_DIR + File.separator + filename);
        ImageIO.write(subImage, "png", outputFile);

        resp.setContentType("image/png");
        IOUtils.copyLarge(
                new FileInputStream(UPLOAD_DIR + File.separator + filename),
                resp.getOutputStream()
        );
    }
}
