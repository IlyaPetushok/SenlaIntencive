package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.product.LiquideDTO;
import project.vapeshop.service.product.LiquideService;

@RestController
@RequestMapping("/liquides")
public class ControllerLiquide {
    LiquideService service;

    @Autowired
    public ControllerLiquide(LiquideService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> insert(@RequestBody LiquideDTO liquideDTO) {
        try {
            return new ResponseEntity<>(service.addItem(liquideDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{liquide-id}")
    public ResponseEntity<?> readId(@PathVariable("liquide-id") Integer id){
        try {
            return new ResponseEntity<>(service.showItem(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> read() {
        try {
            return new ResponseEntity<>(service.showItems(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{liquide-id}")
    public boolean delete(@PathVariable("liquide-id") Integer id) {
        return service.deleteItem(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody LiquideDTO liquideDTO) {
        try {
            return new ResponseEntity<>(service.updateItem(liquideDTO), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/type/{typeNicotine}")
    public ResponseEntity<?> showLiquideTypeNicotine(@PathVariable("typeNicotine") String typeNicotine){
        try {
            return new ResponseEntity<>(service.showLiquideByNicotine(typeNicotine), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
