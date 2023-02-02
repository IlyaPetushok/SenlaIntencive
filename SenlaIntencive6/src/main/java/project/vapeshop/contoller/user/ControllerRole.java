package project.vapeshop.contoller.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.user.RoleDTO;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.user.RoleService;
import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerRole {
    RoleService service;

    @Autowired
    public ControllerRole(RoleService service) {
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
        List<RoleDTO> roleDTOS=new ArrayList<>();
        roleDTOS.add(new RoleDTO("Admin"));
        roleDTOS.add(new RoleDTO("User"));
        return service.addObjects(roleDTOS);
    }

    public List<String> read() {
        List<String> stringList=new ArrayList<>();
        for(RoleDTO roleDTO:service.showObjects()){
            stringList.add(MapperJson.mapperToJson(roleDTO));
        }
        return stringList;
    }

    public boolean delete() {
        return service.deleteObject(1);
    }

    public RoleDTO update() {
        return service.updateObject(new RoleDTO(0,"zamAdmin"));
    }
}
