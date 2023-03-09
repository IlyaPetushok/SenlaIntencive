package project.vapeshop.contoller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.common.RatingDTOFullInfo;
import project.vapeshop.service.common.RatingService;

@RestController
@RequestMapping("/ratings")
public class ControllerRating {
    RatingService service;

    @Autowired
    public ControllerRating(RatingService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> insert(@RequestBody RatingDTOFullInfo ratingDTOFullInfo) {
        return new ResponseEntity<>(service.addObject(ratingDTOFullInfo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> read() {
        return new ResponseEntity<>(service.showObjects(), HttpStatus.OK);
    }

    @GetMapping("/{rating-id}")
    public ResponseEntity<?> readId(@PathVariable("rating-id") Integer id) {
        return new ResponseEntity<>(service.showObject(id), HttpStatus.OK);
    }

    @DeleteMapping("/{rating-id}")
    public boolean delete(@PathVariable("rating-id") Integer id) {
        return service.deleteObject(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody RatingDTOFullInfo ratingDTOFullInfo) {
        return new ResponseEntity<>(service.updateObject(ratingDTOFullInfo), HttpStatus.UPGRADE_REQUIRED);
    }
}
