package project.vapeshop.contoller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.service.common.OrderService;

@RestController
@RequestMapping("/order")
public class ControllerOrder {
    OrderService service;


    @Autowired
    public ControllerOrder(OrderService service) {
        this.service = service;
    }


    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody OrderDTOFullInfo orderDTOFullInfo) {
        try {
            return new ResponseEntity<>(service.addObject(orderDTOFullInfo), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/getAll")
    public ResponseEntity<?> read() {
        try {
            return new ResponseEntity<>(service.showObjects(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/find/{id}")
    public ResponseEntity<?> read(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(service.showObject(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('DELETE')")
    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return service.deleteObject(id);
    }


    @PreAuthorize("hasAuthority('UPDATE')")
    @PostMapping("/update")
    private ResponseEntity<?> update(@RequestBody OrderDTOFullInfo orderDTOFullInfo) {
        try {
            return new ResponseEntity<>(service.updateObject(orderDTOFullInfo), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
