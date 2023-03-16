package project.vapeshop.contoller.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.contoller.authencticate.AuthenticationController;
import project.vapeshop.dto.filter.UserDTOFilter;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.service.user.UserService;

@RestController
@RequestMapping("/users")
public class ControllerUser {
    UserService service;
    private final static Logger logg= LogManager.getLogger(AuthenticationController.class);


    @Autowired
    public ControllerUser(UserService service) {
        this.service = service;
    }


    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UserDTOForRegistration userDTOForRegistration) {
        logg.info("start");
        logg.debug("This is a debug message");
        logg.info("This is an info message");
        logg.warn("This is a warn message");
        logg.error("This is an error message");
        return new ResponseEntity<>(service.addObject(userDTOForRegistration), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping
    public ResponseEntity<?> read() {
        return new ResponseEntity<>(service.showObjects(), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping("/{user-id}")
    public boolean delete(@PathVariable("user-id") Integer id) {
        return service.deleteObject(id);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{user-id}")
    public ResponseEntity<?> read(@PathVariable("user-id") Integer id)  {
        return new ResponseEntity<>(service.showObject(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserDTOForRegistration userDTOForRegistration) {
        return new ResponseEntity<>(service.updateObject(userDTOForRegistration), HttpStatus.UPGRADE_REQUIRED);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/filter")
    public ResponseEntity<?> readByFilter(@RequestBody UserDTOFilter userDTOFilter){
        return new ResponseEntity<>(service.userFindByFilter(userDTOFilter),HttpStatus.OK);
    }
}
