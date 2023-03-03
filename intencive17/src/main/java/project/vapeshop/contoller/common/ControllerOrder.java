package project.vapeshop.contoller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.service.common.OrderService;

@RestController
@RequestMapping("/orders")
public class ControllerOrder {
    OrderService service;


    @Autowired
    public ControllerOrder(OrderService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> insert(@RequestBody OrderDTOFullInfo orderDTOFullInfo) {
        try {
            return new ResponseEntity<>(service.addObject(orderDTOFullInfo), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> read() {
        try {
            return new ResponseEntity<>(service.showObjects(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{order-id}")
    public ResponseEntity<?> read(@PathVariable("order-id") Integer id) {
        try {
            return new ResponseEntity<>(service.showObject(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<?> readByStatus(@PathVariable("status") String status){
        try {
            return new ResponseEntity<>(service.showObjectsFindByStatus(status), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{order-id}")
    public boolean delete(@PathVariable("order-id") int id) {
        return service.deleteObject(id);
    }


    @PutMapping
    public ResponseEntity<?> update(@RequestBody OrderDTOFullInfo orderDTOFullInfo) {
        try {
            return new ResponseEntity<>(service.updateObject(orderDTOFullInfo), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
