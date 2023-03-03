package project.vapeshop.contoller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.user.UserDTOForAuthorization;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.exception.NotFoundException;
import project.vapeshop.service.user.UserService;

@RestController
@RequestMapping("/users")
public class ControllerUser {
    UserService service;

    @Autowired
    public ControllerUser(UserService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UserDTOForRegistration userDTOForRegistration) {
            return new ResponseEntity<>(service.addItem(userDTOForRegistration), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> read() {
            return new ResponseEntity<>(service.showItems(), HttpStatus.OK);
    }

    @DeleteMapping("/{user-id}")
    public boolean delete(@PathVariable("user-id") Integer id) {
        return service.deleteItem(id);
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<?> read(@PathVariable("user-id") Integer id)  {
            return new ResponseEntity<>(service.showItem(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserDTOForRegistration userDTOForRegistration) {
            return new ResponseEntity<>(service.updateItem(userDTOForRegistration), HttpStatus.UPGRADE_REQUIRED);
    }

    @PostMapping("/authorization")
    public ResponseEntity<?> authorization(@RequestBody UserDTOForAuthorization userDTOForAuthorization) {
            return new ResponseEntity<>(service.userFindByLoginWithPassword(userDTOForAuthorization), HttpStatus.OK);
    }
}
