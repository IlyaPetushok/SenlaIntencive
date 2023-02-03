package project.vapeshop.contoller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.ItemService;

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
        System.out.println(read());
        if(delete()){
            System.out.println("Объекты были удалны");
        }
        if (update() != null) {
            System.out.println("Был обнавлён");
        }        System.out.println(read());
    }

    private boolean insert() {
        List<ItemDTOFullInfo> items = new ArrayList<>();
        items.add(new ItemDTOFullInfo("photo5", "HotSpot BubleGum", 2, new BigDecimal(Double.toString(23.0)), 15));
        items.add(new ItemDTOFullInfo("photo6", "Husky Apple", 2, new BigDecimal(Double.toString(19.0)), 20));
        return itemService.addItems(items);
    }

    public List<String> read() {
        List<String> stringList=new ArrayList<>();
        for (ItemDTOInfoForCatalog itemDTOInfoForCatalog : itemService.showItems()) {
            stringList.add(MapperJson.mapperToJson(itemDTOInfoForCatalog));
        }
        return stringList;
    }

    public boolean delete() {
        return itemService.deleteItem(1);
    }

    public ItemDTOInfoForCatalog update() {
        return itemService.updateItem(new ItemDTOFullInfo(0, "photo5", "HotSpot Banana)", 2, new BigDecimal(Double.toString(15.0)), 5));
    }
}
