package project.vapeshop.contoller.authencticate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.entity.user.User;
import project.vapeshop.security.JwtProvider;
import project.vapeshop.service.user.UserService;

@RestController
public class AuthenticationController {
    private final UserService userService;
    private final JwtProvider jwtProvider;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthenticationController(UserService userService, JwtProvider jwtProvider, ModelMapper modelMapper) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/authorization")
    public ResponseEntity<?> authorization(@RequestBody UserDTOForRegistration userDTOForRegistration) {
        UserDTOForRegistration user = userService.userInput(userDTOForRegistration);
        String token = jwtProvider.generatedToken(modelMapper.map(user, User.class));
        userService.deleteObject(3);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody UserDTOForRegistration userDTOForRegistration){
        try {
            return new ResponseEntity<>(userService.addObject(userDTOForRegistration), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/admin/showUsers")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<?> showUser(){
        return new ResponseEntity<>(userService.showObjects(),HttpStatus.OK);
    }
}
