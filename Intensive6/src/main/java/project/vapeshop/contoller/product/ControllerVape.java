package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.VapeDTO;
import project.vapeshop.entity.product.Item;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.product.VapeService;
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
        insert();
        System.out.println(readId());
        update();
        delete();
        System.out.println(read());
    }

    private boolean insert() {
        List<VapeDTO> vapeDTOList=new ArrayList<>();
        vapeDTOList.add(new VapeDTO(120,22450,"Мод",new Item(2)));
        vapeDTOList.add(new VapeDTO(30,5000,"Подик",new Item(3)));
        return service.addItems(vapeDTOList);
    }

    public String readId(){
        return MapperJson.mapperToJson(service.showItem(2));
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
        return service.updateItem(new VapeDTO(4,225,8000,"Мод",new Item(4)));
    }
}
