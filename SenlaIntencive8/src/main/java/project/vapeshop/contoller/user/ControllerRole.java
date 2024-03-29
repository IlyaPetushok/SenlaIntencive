package project.vapeshop.contoller.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.user.PrivilegesDTO;
import project.vapeshop.dto.user.RoleDTO;
import project.vapeshop.service.user.RoleService;

@RestController
@RequestMapping("/roles")
public class ControllerRole {
    RoleService service;

    @Autowired
    public ControllerRole(RoleService service) {
        this.service = service;
    }


    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody RoleDTO roleDTO) {
        return new ResponseEntity<>(service.addObject(roleDTO), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping
    public ResponseEntity<?> read() {
        return new ResponseEntity<>(service.showObjects(), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{role-id}")
    public ResponseEntity<?> read(@PathVariable("role-id") Integer id) {
        return new ResponseEntity<>(service.showObject(id), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping("/{role-id}")
    public boolean delete(@PathVariable("role-id") Integer id) {
        return service.deleteObject(id);
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody RoleDTO roleDTO) {
        return new ResponseEntity<>(service.updateObject(roleDTO), HttpStatus.UPGRADE_REQUIRED);
    }

    @GetMapping("/privilege")
    public ResponseEntity<?> readByPrivilege(@RequestBody PrivilegesDTO privilegesDTO) {
        return new ResponseEntity<>(service.showObjectFindPrivilege(privilegesDTO), HttpStatus.UPGRADE_REQUIRED);
    }
}
