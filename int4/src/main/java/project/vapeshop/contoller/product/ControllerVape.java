package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.VapeDTO;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.VapeService;
import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerVape {
    VapeService service;

    @Autowired
    public ControllerVape(VapeService service) {
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
        List<VapeDTO> vapeDTOList=new ArrayList<>();
        vapeDTOList.add(new VapeDTO(120,22450,"Мод"));
        vapeDTOList.add(new VapeDTO(30,5000,"Подик"));
        return service.addItems(vapeDTOList);
    }

    public List<String> read() {
        List<String> stringList=new ArrayList<>();
        for (VapeDTO vapeDTO:service.showItems()) {
            stringList.add(MapperJson.mapperToJson(vapeDTO));
        }
        return stringList;
    }

    public boolean delete() {
        return service.deleteItem(1);
    }

    public VapeDTO update() {
        return service.updateItem(new VapeDTO(0,100,8000,"Подик"));
    }
}
