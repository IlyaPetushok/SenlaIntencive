package project.vapeshop.contoller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.common.RatingDTOFullInfo;
import project.vapeshop.service.common.RatingService;

@RestController
@RequestMapping("/rating")
public class ControllerRating {
    RatingService service;

    @Autowired
    public ControllerRating(RatingService service) {
        this.service = service;
    }

    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody RatingDTOFullInfo ratingDTOFullInfo) {
        try {
            return new ResponseEntity<>(service.addObject(ratingDTOFullInfo), HttpStatus.CREATED);
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
    public ResponseEntity<?> readId(@PathVariable("id") Integer id) {
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
    public ResponseEntity<?> update(@RequestBody RatingDTOFullInfo ratingDTOFullInfo) {
        try {
            return new ResponseEntity<>(service.updateObject(ratingDTOFullInfo), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}