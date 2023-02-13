package project.vapeshop.config;

import liquibase.integration.spring.SpringLiquibase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@ComponentScan("project.vapeshop")
@EnableAspectJAutoProxy
@PropertySource("classpath:aplication.properties")
public class SpringConfig {
    Environment environment;

    @Autowired
    public SpringConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ModelMapper getMapper(){
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
//    public DataSource getDataSource(){
//        DriverManagerDataSource dataSource=new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
//        dataSource.setUsername(environment.getRequiredProperty("db.username"));
//        dataSource.setPassword(environment.getRequiredProperty("db.password"));
//        dataSource.setUrl(environment.getRequiredProperty("db.url"));
//        return dataSource;
//    }
}
