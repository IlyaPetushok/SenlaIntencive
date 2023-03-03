package vapeshop.test.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("project.vapeshop")
@PropertySource("classpath:test.properties")
public class H2Config {


    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${test.driver}")
    private String driver;
    @Value("${test.url}")
    private String url;
    @Value("${test.password}")
    private String password;
    @Value("${test.username}")
    private String username;
    @Value("${spring.liquibase.change-log}")
    private String pathLiquibase;
    @Value("${test.hibernate.dialect}")
    private String dialect;


    public H2Config() {
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean
    public SpringLiquibase liquibase()  {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(pathLiquibase);
        liquibase.setDataSource(getDataSource());
        return liquibase;
    }


    @Bean
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", true);
        return properties;
    }
}
