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
        if(insert()){
            System.out.println("Объекты юыли добавлены");
        }
//        System.out.println(read());
//        if(delete()){
//            System.out.println("Объекты были удалны");
//        }
//        if (update() != null) {
//            System.out.println("Был обнавлён");
//        }
//        System.out.println(read());
    }

    private boolean insert() {
        Category category=new Category();
        return itemService.addItem(new ItemDTOFullInfo("photo5", "HotSpot BubleGum", category, new BigDecimal(Double.toString(23.0)), 15));
    }

    public List<String> read() {
        List<String> stringList=new ArrayList<>();
        for (ItemDTOInfoForCatalog itemDTOInfoForCatalog : itemService.showItems()) {
            stringList.add(MapperJson.mapperToJson(itemDTOInfoForCatalog));
        }
        return stringList;
    }

    public boolean delete() {
        return itemService.deleteItem(99);
    }

    public ItemDTOInfoForCatalog update() {
        Category category=new Category();
        return itemService.updateItem(new ItemDTOFullInfo(100, "photo123", "HotSpot Banana)", category, new BigDecimal(Double.toString(15.0)), 5));
    }
}
