package project.vapeshop.main;

import org.example.annotation.Autowired;
import org.example.annotation.Component;
import org.example.installer.ComponentInstaller;
import project.vapeshop.contoller.ControllerVapeShop;

@Component
public class Main {
    @Autowired
    static ControllerVapeShop controllerVapeShop;

    public static void main(String[] args) {
        ComponentInstaller.processAnnotation("project.vapeshop");
        controllerVapeShop.execute();
    }
}
