package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.product.VaporizerDTO;
import project.vapeshop.service.product.VaporizerService;

@RestController
@RequestMapping("/vaporizers")
public class ControllerVaporizer {
    VaporizerService service;

    @Autowired
    public ControllerVaporizer(VaporizerService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> insert(@RequestBody VaporizerDTO vaporizerDTO) {
        try {
            return new ResponseEntity<>(service.addItem(vaporizerDTO), HttpStatus.CREATED);
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

    @GetMapping("/{vape-id}")
    public ResponseEntity<?> read(@PathVariable("vape-id") Integer id) {
        try {
            return new ResponseEntity<>(service.showItem(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{vape-id}")
    public boolean delete(@PathVariable("vape-id") Integer id) {
       return service.deleteItem(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody VaporizerDTO vaporizerDTO) {
        try {
            return new ResponseEntity<>(service.updateItem(vaporizerDTO), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/type/{typeVaporizer}")
    public ResponseEntity<?> showVaporizerTypeNicotine(@PathVariable("typeVaporizer") String type) {
        try {
            return new ResponseEntity<>(service.showVaporizerByType(type), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
