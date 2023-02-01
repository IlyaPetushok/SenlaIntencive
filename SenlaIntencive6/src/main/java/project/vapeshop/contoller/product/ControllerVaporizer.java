package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.VaporizerDTO;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.VaporizerService;
import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerVaporizer {
    VaporizerService service;

    @Autowired
    public ControllerVaporizer(VaporizerService service) {
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
        List<VaporizerDTO> vaporizerDTOList=new ArrayList<>();
        vaporizerDTOList.add(new VaporizerDTO(0.6,"испаритель"));
        vaporizerDTOList.add(new VaporizerDTO(0.6,"картридж"));
        return service.addItems(vaporizerDTOList);
    }

    public List<String> read() {
        List<String > stringList=new ArrayList<>();
        for(VaporizerDTO vaporizerDTO: service.showItems()){
            stringList.add(MapperJson.mapperToJson(vaporizerDTO));
        }
        return stringList;
    }

    public boolean delete() {
       return service.deleteItem(1);
    }

    public VaporizerDTO update() {
        return  service.updateItem(new VaporizerDTO(0,1.8,"картридж"));
    }
}
