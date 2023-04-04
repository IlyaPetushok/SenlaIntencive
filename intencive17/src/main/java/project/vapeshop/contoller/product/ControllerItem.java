package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.service.product.CategoryService;
import project.vapeshop.service.product.ItemService;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ControllerItem {
    ItemService itemService;
    CategoryService categoryService;

    @Autowired
    public ControllerItem(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ItemDTOFullInfo item) {
        return new ResponseEntity<>(itemService.addItem(item), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ItemDTOInfoForCatalog>> read() {
        return new ResponseEntity<>(itemService.showItems(), HttpStatus.OK);
    }

    @GetMapping("/{item-id}")
    public ResponseEntity<?> readId(@PathVariable("item-id") Integer id) {
        return new ResponseEntity<>(itemService.showItem(id), HttpStatus.OK);
    }

    @DeleteMapping("/{item-id}")
    public boolean delete(@PathVariable("item-id") Integer id) {
        return itemService.deleteItem(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ItemDTOFullInfo itemDTOFullInfo) {
        return new ResponseEntity<>(itemService.updateItem(itemDTOFullInfo), HttpStatus.UPGRADE_REQUIRED);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> readItemByCategory(@PathVariable("category") String nameCategory) {
        return new ResponseEntity<>(itemService.showItemByCategory(nameCategory), HttpStatus.OK);
    }
}
