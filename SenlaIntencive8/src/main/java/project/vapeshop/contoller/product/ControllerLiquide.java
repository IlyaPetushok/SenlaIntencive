package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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


    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody LiquideDTOFullInfo liquideDTOFullInfo) {
        return new ResponseEntity<>(service.addItem(liquideDTOFullInfo), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{liquide-id}")
    public ResponseEntity<?> readId(@PathVariable("liquide-id") Integer id){
        return new ResponseEntity<>(service.showItem(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping
    public ResponseEntity<?> read() {
        return new ResponseEntity<>(service.showItems(), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping("/{liquide-id}")
    public boolean delete(@PathVariable("liquide-id") Integer id) {
        return service.deleteItem(id);
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody LiquideDTOFullInfo liquideDTOFullInfo) {
        return new ResponseEntity<>(service.updateItem(liquideDTOFullInfo), HttpStatus.UPGRADE_REQUIRED);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/type/{typeNicotine}")
    public ResponseEntity<?> showLiquideTypeNicotine(@PathVariable("typeNicotine") String typeNicotine){
        return new ResponseEntity<>(service.showLiquideByNicotine(typeNicotine), HttpStatus.UPGRADE_REQUIRED);
    }
}
