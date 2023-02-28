package project.vapeshop.contoller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.user.PrivilegesDTO;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.user.PrivilegesService;
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
        insert();
        System.out.println(read());
        update();
        delete();
        System.out.println(read());
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
        return service.deleteObject(3);
    }

    public PrivilegesDTO update() {
        return service.updateObject(new PrivilegesDTO(2,"DeleteUserAndChangeStatus"));
    }
}
