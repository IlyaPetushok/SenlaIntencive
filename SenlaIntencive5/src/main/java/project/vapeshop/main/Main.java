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


public class Main implements Runnable{

    @Override
    public void run() {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        ControllerItem controllerItem =applicationContext.getBean(ControllerItem.class);
        controllerItem.execute();
    }

    public static void main(String[] args) {
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        Main thread1=new Main();
        Main thread2=new Main();
        Thread thread=new Thread(thread1);
        Thread thread22=new Thread(thread2);
//        ControllerItem controllerItem =applicationContext.getBean(ControllerItem.class);
//        controllerItem.execute();
        thread.start();
        thread22.start();
    }
}
