package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.product.VaporizerDTO;
import project.vapeshop.service.product.VaporizerService;

@RestController
@RequestMapping("/vaporizer")
public class ControllerVaporizer {
    VaporizerService service;

    @Autowired
    public ControllerVaporizer(VaporizerService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody VaporizerDTO vaporizerDTO) {
        try {
            return new ResponseEntity<>(service.addItem(vaporizerDTO), HttpStatus.CREATED);
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

    @GetMapping("/find/{id}")
    public ResponseEntity<?> read(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(service.showItem(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
       return service.deleteItem(id);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody VaporizerDTO vaporizerDTO) {
        try {
            return new ResponseEntity<>(service.updateItem(vaporizerDTO), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/show/{typeVaporizer}")
    public ResponseEntity<?> showVaporizerTypeNicotine(@PathVariable("typeVaporizer") String type) {
        try {
            return new ResponseEntity<>(service.showVaporizerByType(type), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
