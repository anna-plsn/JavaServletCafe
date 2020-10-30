import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GlobalListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/dbtest?useSSL=false");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setMaximumPoolSize(20);

        HikariDataSource hikariDataSource =new HikariDataSource(hikariConfig);

        sce.getServletContext().setAttribute("datasource", hikariDataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
