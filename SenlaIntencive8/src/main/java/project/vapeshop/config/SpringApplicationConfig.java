package project.vapeshop.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("project.vapeshop")
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:aplication.properties")
public class SpringApplicationConfig implements WebMvcConfigurer {

    public SpringApplicationConfig() {
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON_UTF8);
    }
}
