package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.product.VaporizerDTOFullInfo;
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
    public ResponseEntity<?> insert(@RequestBody VaporizerDTOFullInfo vaporizerDTOFullInfo) {
            return new ResponseEntity<>(service.addItem(vaporizerDTOFullInfo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> read() {
            return new ResponseEntity<>(service.showItems(), HttpStatus.OK);
    }

    @GetMapping("/{vape-id}")
    public ResponseEntity<?> readId(@PathVariable("vape-id") Integer id) {
            return new ResponseEntity<>(service.showItem(id), HttpStatus.OK);
    }

    @DeleteMapping("/{vape-id}")
    public boolean delete(@PathVariable("vape-id") Integer id) {
       return service.deleteItem(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody VaporizerDTOFullInfo vaporizerDTOFullInfo) {
            return new ResponseEntity<>(service.updateItem(vaporizerDTOFullInfo), HttpStatus.UPGRADE_REQUIRED);
    }

    @GetMapping("/type/{typeVaporizer}")
    public ResponseEntity<?> showVaporizerTypeNicotine(@PathVariable("typeVaporizer") String type) {
            return new ResponseEntity<>(service.showVaporizerByType(type), HttpStatus.UPGRADE_REQUIRED);
    }
}
