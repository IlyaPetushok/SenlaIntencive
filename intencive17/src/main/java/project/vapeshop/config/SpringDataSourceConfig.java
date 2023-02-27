package project.vapeshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:aplication.properties")
public class SpringDataSourceConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.password}")
    private String password;
    @Value("${db.username}")
    private String username;
    @Value("${hibernate.dialect}")
    private String dialect;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(getDataSource());
        entityManagerFactory.setPackagesToScan("project.vapeshop");
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(getProperties());
        return entityManagerFactory;
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
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",dialect);
        properties.put("hibernate.show_sql", true);
        return properties;
    }


    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }
}
