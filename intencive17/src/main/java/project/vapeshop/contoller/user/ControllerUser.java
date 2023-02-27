package project.vapeshop.contoller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.user.UserDTOForAuthorization;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.service.user.UserService;

@RestController
@RequestMapping("/user")
public class ControllerUser {
    UserService service;

    @Autowired
    public ControllerUser(UserService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody UserDTOForRegistration userDTOForRegistration) {
        try {
            return new ResponseEntity<>(service.addItem(userDTOForRegistration), HttpStatus.CREATED);
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

    @GetMapping("/find/{id}")
    public ResponseEntity<?> read(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(service.showItem(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserDTOForRegistration userDTOForRegistration) {
        try {
            return new ResponseEntity<>(service.updateItem(userDTOForRegistration), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/authorization")
    public ResponseEntity<?> authorization(@RequestBody UserDTOForAuthorization userDTOForAuthorization) {
        try {
            return new ResponseEntity<>(service.userFindByLoginWithPassword(userDTOForAuthorization), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
