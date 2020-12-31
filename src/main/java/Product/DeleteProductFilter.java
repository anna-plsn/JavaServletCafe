package Product;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    Delete product from db
 */
@WebFilter(urlPatterns = "/qwer/deleteProduct", filterName = "deleteProduct")
public class DeleteProductFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        DataSource dataSource = (DataSource) servletRequest.getServletContext().getAttribute("datasource");

        int id = Integer.parseInt(servletRequest.getParameter("id"));
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String sql = "DELETE FROM product WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        resp.sendRedirect("/productDB");
    }
}
