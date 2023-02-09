package project.vapeshop.contoller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.entity.product.Category;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.product.ItemService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerItem {
    ItemService itemService;

    @Autowired
    public ControllerItem(ItemService itemService) {
        this.itemService = itemService;
    }


    public void execute() {
//        if(insert()){
//            System.out.println("Объекты юыли добавлены");
//        }
        System.out.println(readId());
//        update();
//        if(delete()){
//            System.out.println("Объекты были удалны");
//        }
//        if (update() != null) {
//            System.out.println("Был обнавлён");
//        }
//        System.out.println(read());
    }

    private boolean insert() {
        return itemService.addItem(new ItemDTOFullInfo("photo111", "HotSpot BubleGum", new Category(), new BigDecimal(Double.toString(23.0)), 15));
    }

    public List<String> read() {
        List<String> stringList=new ArrayList<>();
        for (ItemDTOInfoForCatalog itemDTOInfoForCatalog : itemService.showItems()) {
            stringList.add(MapperJson.mapperToJson(itemDTOInfoForCatalog));
        }
        return stringList;
    }

    public String readId() {
        return MapperJson.mapperToJson(itemService.showItem(1));
    }



    public boolean delete() {
        return itemService.deleteItem(185);
    }

    public ItemDTOInfoForCatalog update() {
        return itemService.updateItem(new ItemDTOFullInfo(199, "path/photo4", "baby lus", new Category(), new BigDecimal(Double.toString(15.0)), 10));
    }
}
