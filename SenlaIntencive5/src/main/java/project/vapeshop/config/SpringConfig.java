package project.vapeshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("project.vapeshop")
@EnableAspectJAutoProxy
public class SpringConfig {
}
