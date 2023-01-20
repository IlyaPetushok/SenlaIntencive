package project.vapeshop.contoller;

import org.example.annotation.Autowired;
import org.example.annotation.Component;
import project.vapeshop.service.ServiceInterface;

@Component
public class ControllerVapeShop {
    ServiceInterface service;

    @Autowired
    public ControllerVapeShop(ServiceInterface service) {
        this.service = service;
    }

    public void execute(){
        service.execute();
    }
}
