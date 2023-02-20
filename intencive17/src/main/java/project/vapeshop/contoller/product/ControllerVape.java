package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.product.VapeDTO;
import project.vapeshop.service.product.VapeService;

@RestController
@RequestMapping("/vape")
public class ControllerVape {
    VapeService service;

    @Autowired
    public ControllerVape(VapeService service) {
        this.service = service;
    }


    @PostMapping("/add")
    private ResponseEntity<?> insert(@RequestBody VapeDTO vapeDTO) {
        try {
            return new ResponseEntity<>(service.addItem(vapeDTO), HttpStatus.CREATED);
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
    public ResponseEntity<?> update(@RequestBody VapeDTO vapeDTO) {
        try {
            return new ResponseEntity<>(service.updateItem(vapeDTO), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
