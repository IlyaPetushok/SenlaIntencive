package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.CategoryDTO;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.entity.product.Category;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.product.CategoryService;
import project.vapeshop.service.product.ItemService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerItem {
    ItemService itemService;
    CategoryService categoryService;

    @Autowired
    public ControllerItem(ItemService itemService) {
        this.itemService = itemService;
    }


    public void execute() {
//        insert();
        System.out.println(readId());
//        update();
//        delete();
        System.out.println(read());
    }

    private boolean insert() {
        return itemService.addItem(new ItemDTOFullInfo("photo4", "HotSpot BubleGum", new Category("Жидкости"), new BigDecimal(Double.toString(23.0)), 15));
    }

    public List<String> read() {
        List<String> stringList = new ArrayList<>();
        for (ItemDTOInfoForCatalog itemDTOInfoForCatalog : itemService.showItems()) {
            stringList.add(MapperJson.mapperToJson(itemDTOInfoForCatalog));
        }
        return stringList;
    }

    public String readId() {
        return MapperJson.mapperToJson(itemService.showItem(20));
    }

    public boolean delete() {
        return itemService.deleteItem(16);
    }

    public ItemDTOInfoForCatalog update() {
        return itemService.updateItem(new ItemDTOFullInfo(19, "path/photo4", "Baby Plus", new Category(), new BigDecimal(Double.toString(15.0)), 10));
    }
}
