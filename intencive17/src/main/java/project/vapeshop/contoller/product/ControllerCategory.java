package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.product.CategoryDTO;
import project.vapeshop.service.product.CategoryService;

@RestController
@RequestMapping("/categories")
public class ControllerCategory {
    CategoryService service;

    @Autowired
    public ControllerCategory(CategoryService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> insert(@RequestBody CategoryDTO categoryDTO) {
            return new ResponseEntity<>(service.addObject(categoryDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{category-id}")
    public ResponseEntity<?> readId(@PathVariable("category-id") Integer id){
            return new ResponseEntity<>(service.showObject(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> read() {
            return new ResponseEntity<>(service.showObjects(), HttpStatus.OK);
    }

    @DeleteMapping("/{category-id}")
    public boolean delete(@PathVariable("category-id") Integer id) {
        return service.deleteObject(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CategoryDTO categoryDTO) {
            return new ResponseEntity<>(service.updateObject(categoryDTO), HttpStatus.UPGRADE_REQUIRED);
    }
}
