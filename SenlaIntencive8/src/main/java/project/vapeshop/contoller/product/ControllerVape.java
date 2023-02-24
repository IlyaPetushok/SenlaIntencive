package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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


    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping("/add")
    private ResponseEntity<?> insert(@RequestBody VapeDTO vapeDTO) {
        try {
            return new ResponseEntity<>(service.addItem(vapeDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/find/{id}")
    public ResponseEntity<?> readId(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(service.showItem(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/getAll")
    public ResponseEntity<?> read() {
        try {
            return new ResponseEntity<>(service.showItems(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('DELETE')")
    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return service.deleteItem(id);
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody VapeDTO vapeDTO) {
        try {
            return new ResponseEntity<>(service.updateItem(vapeDTO), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/show/{typeVape}")
    public ResponseEntity<?> showVapeTypeNicotine(@PathVariable("typeVape") String type) {
        try {
            return new ResponseEntity<>(service.showVapeByType(type), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
