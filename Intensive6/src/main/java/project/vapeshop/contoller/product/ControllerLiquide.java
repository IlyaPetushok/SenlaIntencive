package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.LiquideDTO;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.product.LiquideService;

import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerLiquide {
    LiquideService service;

    @Autowired
    public ControllerLiquide(LiquideService service) {
        this.service = service;
    }


    public void execute() {
//        if (insert()) {
//            System.out.println("Объекты юыли добавлены");
//        }
//        System.out.println(read());
        if (delete()) {
            System.out.println("Объекты были удалны");
        }
//        if (update() != null) {
//            System.out.println("Был обнавлён");
//        }
        System.out.println(read());
    }

    private boolean insert() {
        List<LiquideDTO> liquideDTOList = new ArrayList<>();
        liquideDTOList.add(new LiquideDTO("Ежевика", 45, "солевой", 30));
        liquideDTOList.add(new LiquideDTO("Тропический чай", 50, "солевой", 30));
        return service.addItems(liquideDTOList);
    }

    public List<String> read() {
        List<String> stringList = new ArrayList<>();
        for (LiquideDTO liquideDTO : service.showItems()) {
            stringList.add(MapperJson.mapperToJson(liquideDTO));
        }
        return stringList;
    }

    public boolean delete() {
        return service.deleteItem(7);
    }

    public LiquideDTO update() {
        return service.updateItem(new LiquideDTO(3, "Малина с Лимоном", 20, "солевой", 30));
    }
}
