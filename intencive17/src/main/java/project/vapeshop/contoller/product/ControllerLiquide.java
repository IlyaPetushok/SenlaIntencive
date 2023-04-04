package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.product.LiquideDTOFullInfo;
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
    public ResponseEntity<?> insert(@RequestBody LiquideDTOFullInfo liquideDTOFullInfo) {
            return new ResponseEntity<>(service.addItem(liquideDTOFullInfo), HttpStatus.CREATED);
    }

    @GetMapping("/{liquide-id}")
    public ResponseEntity<?> readId(@PathVariable("liquide-id") Integer id){
            return new ResponseEntity<>(service.showItem(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> read() {
            return new ResponseEntity<>(service.showItems(), HttpStatus.OK);
    }

    @DeleteMapping("/{liquide-id}")
    public boolean delete(@PathVariable("liquide-id") Integer id) {
        return service.deleteItem(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody LiquideDTOFullInfo liquideDTOFullInfo) {
            return new ResponseEntity<>(service.updateItem(liquideDTOFullInfo), HttpStatus.UPGRADE_REQUIRED);
    }


    @GetMapping("/type/{typeNicotine}")
    public ResponseEntity<?> showLiquideTypeNicotine(@PathVariable("typeNicotine") String typeNicotine){
            return new ResponseEntity<>(service.showLiquideByNicotine(typeNicotine), HttpStatus.UPGRADE_REQUIRED);
    }
}
