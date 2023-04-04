package project.vapeshop.contoller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.dto.user.UserDTOForCommon;
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
            return new ResponseEntity<>(service.addObject(orderDTOFullInfo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> read() {
            return new ResponseEntity<>(service.showObjects(), HttpStatus.OK);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity<?> read(@PathVariable("order-id") Integer id) {
            return new ResponseEntity<>(service.showObject(id), HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<?> readByStatus(@PathVariable("status") String status) {
        return new ResponseEntity<>(service.showObjectsFindByStatus(status), HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public boolean delete(@PathVariable("order-id") int id) {
        return service.deleteObject(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody OrderDTOFullInfo orderDTOFullInfo) {
        return new ResponseEntity<>(service.updateObject(orderDTOFullInfo), HttpStatus.UPGRADE_REQUIRED);
    }

    @PostMapping("/users")
    public ResponseEntity<?> readByUser(@RequestBody UserDTOForCommon userDTOForCommon) {
        return new ResponseEntity<>(service.showObjectsFindByUser(userDTOForCommon), HttpStatus.OK);
    }
}
