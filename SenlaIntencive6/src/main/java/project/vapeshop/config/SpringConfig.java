package project.vapeshop.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("project.vapeshop")
@EnableTransactionManagement
@PropertySource("classpath:aplication.properties")
public class SpringConfig {
    Environment environment;

    @Autowired
    public SpringConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }


    //    @Bean
//    public SpringLiquibase liquibase(){
//        SpringLiquibase liquibase=new SpringLiquibase();
//        liquibase.setChangeLog("src/main/liquibase/changelog-master.xml");
//        liquibase.setDataSource(getDataSource());
//        return liquibase;
//    }
//
//    @Bean
//    public EntityManager entityManager(){
//        return Persistence.createEntityManagerFactory("enm").createEntityManager();
//    }

//    @Bean
//    public EntityManager entityManager(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){
//        EntityManagerFactory entityManagerFactory=entityManagerFactoryBean.getNativeEntityManagerFactory();
//        return entityManagerFactory.createEntityManager();
//    }

    @Bean
//    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(getDataSource());
//        entityManagerFactory.setPersistenceUnitName("enm");
        entityManagerFactory.setPackagesToScan("project.vapeshop");
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(getProperties());
        return entityManagerFactory;
    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
        dataSource.setUsername(environment.getRequiredProperty("db.username"));
        dataSource.setPassword(environment.getRequiredProperty("db.password"));
        dataSource.setUrl(environment.getRequiredProperty("db.url"));
        return dataSource;
    }
    @Bean
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
