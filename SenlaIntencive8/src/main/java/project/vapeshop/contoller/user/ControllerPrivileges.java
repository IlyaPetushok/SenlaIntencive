package project.vapeshop.contoller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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


    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody PrivilegesDTO privilegesDTO) {
        return new ResponseEntity<>(service.addObject(privilegesDTO), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping
    public ResponseEntity<?> read() {
        return new ResponseEntity<>(service.showObjects(), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{privilege-id}")
    public ResponseEntity<?> read(@PathVariable("privilege-id") Integer id) {
        return new ResponseEntity<>(service.showObject(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping("/{privilege-id}")
    public boolean delete(@PathVariable("privilege-id") Integer id) {
        return service.deleteObject(id);
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody PrivilegesDTO privilegesDTO) {
        return new ResponseEntity<>(service.updateObject(privilegesDTO), HttpStatus.UPGRADE_REQUIRED);
    }
}
