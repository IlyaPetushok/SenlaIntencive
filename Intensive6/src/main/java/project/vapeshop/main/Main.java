package project.vapeshop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.vapeshop.config.SpringConfig;
import project.vapeshop.contoller.common.ControllerOrder;
import project.vapeshop.contoller.common.ControllerRating;
import project.vapeshop.contoller.product.*;
import project.vapeshop.contoller.user.ControllerPrivileges;
import project.vapeshop.contoller.user.ControllerRole;
import project.vapeshop.contoller.user.ControllerUser;


public class Main{
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        ControllerRating controllerItem =applicationContext.getBean(ControllerRating.class);
        controllerItem.execute();
    }
}
