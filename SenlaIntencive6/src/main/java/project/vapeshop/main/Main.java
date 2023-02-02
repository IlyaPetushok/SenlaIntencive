package project.vapeshop.main;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import project.vapeshop.config.SpringConfig;
import project.vapeshop.contoller.common.ControllerOrder;
import project.vapeshop.contoller.common.ControllerRating;
import project.vapeshop.contoller.product.*;
import project.vapeshop.contoller.user.ControllerPrivileges;
import project.vapeshop.contoller.user.ControllerRole;
import project.vapeshop.contoller.user.ControllerUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class Main implements Runnable{

    @Override
    public void run() {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        EntityManagerFactory entityManager=applicationContext.getBean("entityManagerFactory", EntityManagerFactory.class);
        System.out.println(entityManager);
        ControllerItem controllerItem =applicationContext.getBean(ControllerItem.class);
        controllerItem.execute();
    }

    public static void main(String[] args) {
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
//        SpringLiquibase liquibase=applicationContext.getBean("liquibase",SpringLiquibase.class);
        Main thread1=new Main();
//        Main thread2=new Main();
        Thread thread=new Thread(thread1);
//        Thread thread22=new Thread(thread2);
//        ControllerItem controllerItem =applicationContext.getBean(ControllerItem.class);
//        controllerItem.execute();
        thread.start();
//        thread22.start();
    }
}
