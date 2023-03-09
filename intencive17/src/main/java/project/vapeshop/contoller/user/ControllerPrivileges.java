package project.vapeshop.contoller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.user.PrivilegesDTO;
import project.vapeshop.service.user.PrivilegesService;

@RestController
@RequestMapping("/privileges")
public class ControllerPrivileges {
    PrivilegesService service;

    @Autowired
    public ControllerPrivileges(PrivilegesService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> insert(@RequestBody PrivilegesDTO privilegesDTO) {
        return new ResponseEntity<>(service.addObject(privilegesDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> read() {
        return new ResponseEntity<>(service.showObjects(), HttpStatus.OK);
    }

    @GetMapping("/{privilege-id}")
    public ResponseEntity<?> read(@PathVariable("privilege-id") Integer id) {
        return new ResponseEntity<>(service.showObject(id), HttpStatus.OK);
    }

    @DeleteMapping("/{privilege-id}")
    public boolean delete(@PathVariable("privilege-id") Integer id) {
        return service.deleteObject(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PrivilegesDTO privilegesDTO) {
        return new ResponseEntity<>(service.updateObject(privilegesDTO), HttpStatus.UPGRADE_REQUIRED);
    }
}
