package Cart;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebFilter(urlPatterns = "/deleteCart", filterName = "deleteCart")
public class DeleteCartFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        int id_product = Integer.parseInt(servletRequest.getParameter("id_product"));
        int id_user = Integer.parseInt(servletRequest.getParameter("id_user"));

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        DataSource dataSource = (DataSource) servletRequest.getServletContext().getAttribute("datasource");

        String sql = "DELETE FROM user_order WHERE id_user = ? and id_product=?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id_user);
            statement.setInt(2, id_product);
            statement.executeUpdate();
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        resp.sendRedirect("/catalog");
    }
}
