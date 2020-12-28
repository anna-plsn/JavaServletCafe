package Other;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GlobalListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/cafedb?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("2001");
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setMaximumPoolSize(40);

        HikariDataSource hikariDataSource =new HikariDataSource(hikariConfig);

        sce.getServletContext().setAttribute("datasource", hikariDataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

