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
@RequestMapping("/item")
public class ControllerItem {
    ItemService itemService;
    CategoryService categoryService;

    @Autowired
    public ControllerItem(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping("/add")
    private ResponseEntity<?> insert(@RequestBody ItemDTOFullInfo item) {
        try {
            return new ResponseEntity<>(itemService.addItem(item), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ItemDTOInfoForCatalog>> read() {
        try {
            return new ResponseEntity<>(itemService.showItems(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> readId(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(itemService.showItem(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return itemService.deleteItem(id);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ItemDTOFullInfo itemDTOFullInfo) {
        try {
            return new ResponseEntity<>(itemService.updateItem(itemDTOFullInfo), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}