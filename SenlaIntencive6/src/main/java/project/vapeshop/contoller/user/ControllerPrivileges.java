package project.vapeshop.contoller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.user.PrivilegesDTO;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.PrivilegesService;
import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerPrivileges {
    PrivilegesService service;

    @Autowired
    public ControllerPrivileges(PrivilegesService service) {
        this.service = service;
    }

    public void execute() {
        if(insert()){
            System.out.println("Объекты юыли добавлены");
        }
        System.out.println(read());
        if(delete()){
            System.out.println("Объекты были удалны");
        }
        if (update() != null) {
            System.out.println("Был обнавлён");
        }        System.out.println(read());
    }

    private boolean insert() {
        List<PrivilegesDTO> privilegesDTOS=new ArrayList<>();
        privilegesDTOS.add(new PrivilegesDTO("DeleteUser"));
        privilegesDTOS.add(new PrivilegesDTO("Add Product"));
        return service.addObjects(privilegesDTOS);
    }

    public List<String> read() {
        List<String> stringList=new ArrayList<>();
        for(PrivilegesDTO privilegesDTO:service.showObjects()){
            stringList.add(MapperJson.mapperToJson(privilegesDTO));
        }
        return stringList;
    }

    public boolean delete() {
        return service.deleteObject(1);
    }

    public PrivilegesDTO update() {
        return service.updateObject(new PrivilegesDTO(0,"DeleteUserAndChangeStatus"));
    }
}
