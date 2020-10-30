import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.servlet.ServletContextEvent;

public class Test {
    public static void main(String[] args) {
                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/dbtest?useSSL=false");
                hikariConfig.setUsername("root");
                hikariConfig.setPassword("");
                hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
                hikariConfig.setMaximumPoolSize(20);

                HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
            }
        }
