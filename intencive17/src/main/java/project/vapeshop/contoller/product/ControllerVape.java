package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.product.VapeDTOFullInfo;
import project.vapeshop.service.product.VapeService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
@RequestMapping("/vapes")
public class ControllerVape {
    VapeService service;

    @Autowired
    public ControllerVape(VapeService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> insert(@RequestBody VapeDTOFullInfo vapeDTOFullInfo) {
            return new ResponseEntity<>(service.addItem(vapeDTOFullInfo), HttpStatus.CREATED);
    }

    @GetMapping("/{vape-id}")
    public ResponseEntity<?> readId(@PathVariable("vape-id") Integer id){
            return new ResponseEntity<>(service.showItem(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> read() {
            return new ResponseEntity<>(service.showItems(), HttpStatus.OK);
    }

    @DeleteMapping("/{vape-id}")
    public boolean delete(@PathVariable("vape-id") Integer id) {
        return service.deleteItem(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody VapeDTOFullInfo vapeDTOFullInfo) {
            return new ResponseEntity<>(service.updateItem(vapeDTOFullInfo), HttpStatus.UPGRADE_REQUIRED);
    }

    @GetMapping("/type/{typeVape}")
    public ResponseEntity<?> showVapeTypeNicotine(@PathVariable("typeVape") String type){
        return new ResponseEntity<>(service.showVapeByType(type), HttpStatus.UPGRADE_REQUIRED);
    }
}
