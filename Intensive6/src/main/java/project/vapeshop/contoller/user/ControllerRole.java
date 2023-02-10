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
//        insert();
//        read();
        update();
//        delete();
    }

    private boolean insert() {
        List<RoleDTO> roleDTOS=new ArrayList<>();
        roleDTOS.add(new RoleDTO("Admin"));
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
        return service.deleteObject(4);
    }

    public RoleDTO update() {
        return service.updateObject(new RoleDTO(5,"zamAdmin"));
    }
}
