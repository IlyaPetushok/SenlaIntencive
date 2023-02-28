package project.vapeshop.contoller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.entity.user.Role;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.user.UserService;
import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerUser {
    UserService service;

    @Autowired
    public ControllerUser(UserService service) {
        this.service = service;
    }

    public void execute() {
//        insert();
        System.out.println(read());
        update();
        delete();
//        System.out.println(read());
    }

    private boolean insert() {
        List<UserDTOForRegistration> userDTOForRegistrations=new ArrayList<>();
        userDTOForRegistrations.add(new UserDTOForRegistration("Petushok","Ilya","Aleksandrovich","login","pass","a33@mail",new Role(1)));
        userDTOForRegistrations.add(new UserDTOForRegistration("Cluch","Vasya","Pupkin","login2","pass2","vasya@mail",new Role(1)));
        return service.addItems(userDTOForRegistrations);
    }

    public List<String> read() {
        List<String> stringList=new ArrayList<>();
        for(UserDTOAfterAuthorization userDTOAfterAuthorization: service.showItems()){
            stringList.add(MapperJson.mapperToJson(userDTOAfterAuthorization));
        }
        return stringList;
    }

    public boolean delete() {
        return service.deleteItem(6);
    }

    public UserDTOAfterAuthorization update() {
        return service.updateItem(new UserDTOForRegistration(7,"Cluch","ghgjfdr","Pupkin","log","password","vasya@mail",new Role(2)));

    }
}
