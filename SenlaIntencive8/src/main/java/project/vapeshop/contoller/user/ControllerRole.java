package project.vapeshop.contoller.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.user.RoleDTO;
import project.vapeshop.service.user.RoleService;

@RestController
@RequestMapping("/role")
public class ControllerRole {
    RoleService service;

    @Autowired
    public ControllerRole(RoleService service) {
        this.service = service;
    }


    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping("/add")
    private ResponseEntity<?> insert(@RequestBody RoleDTO roleDTO) {
        try {
            return new ResponseEntity<>(service.addObject(roleDTO), HttpStatus.CREATED);
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
    public boolean delete(@PathVariable("id") Integer id) {
        return service.deleteObject(id);
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody RoleDTO roleDTO) {
        try {
            return new ResponseEntity<>(service.updateObject(roleDTO), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
