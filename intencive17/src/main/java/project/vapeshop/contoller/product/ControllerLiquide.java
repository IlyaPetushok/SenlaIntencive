package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.product.LiquideDTO;
import project.vapeshop.entity.product.Item;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.product.LiquideService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/liquide")
public class ControllerLiquide {
    LiquideService service;

    @Autowired
    public ControllerLiquide(LiquideService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody LiquideDTO liquideDTO) {
        try {
            return new ResponseEntity<>(service.addItem(liquideDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> readId(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(service.showItem(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> read() {
        try {
            return new ResponseEntity<>(service.showItems(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return service.deleteItem(id);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody LiquideDTO liquideDTO) {
        try {
            return new ResponseEntity<>(service.updateItem(liquideDTO), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/show/{typeNicotine}")
    public ResponseEntity<?> showLiquideTypeNicotine(@PathVariable("typeNicotine") String typeNicotine){
        try {
            return new ResponseEntity<>(service.showLiquideByNicotine(typeNicotine), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
