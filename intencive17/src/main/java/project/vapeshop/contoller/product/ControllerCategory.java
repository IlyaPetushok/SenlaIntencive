package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import project.vapeshop.dto.product.CategoryDTO;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.product.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class ControllerCategory {
    CategoryService service;

    @Autowired
    public ControllerCategory(CategoryService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody CategoryDTO categoryDTO) {
        try {
            return new ResponseEntity<>(service.addObject(categoryDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> readId(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(service.showObject(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> read() {
        try {
            return new ResponseEntity<>(service.showObjects(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return service.deleteObject(id);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody CategoryDTO categoryDTO) {
        try {
            return new ResponseEntity<>(service.updateObject(categoryDTO), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
