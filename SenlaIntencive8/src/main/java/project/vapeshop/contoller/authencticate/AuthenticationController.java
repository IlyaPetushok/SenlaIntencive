package project.vapeshop.contoller.authencticate;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.dto.user.UserDTOForAuthorization;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.security.JwtProvider;
import project.vapeshop.service.user.UserService;

@RestController
public class AuthenticationController {
    private final UserService userService;
    private final JwtProvider jwtProvider;
//    private static final Logger logg= LoggerFactory.getLogger(AuthenticationController.class);

    Logger logg= LogManager.getLogger(AuthenticationController.class);
    @Autowired
    public AuthenticationController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/authorization")
    public ResponseEntity<?> authorization(@RequestBody UserDTOForAuthorization userDTOForAuthorization) {
        System.out.println("cmsnsjnjsvnjkvnds");
        logg.info("start");
        logg.debug("This is a debug message");
        logg.info("This is an info message");
        logg.warn("This is a warn message");
        logg.error("This is an error message");
        UserDTOAfterAuthorization user = userService.userFindByLoginWithPassword(userDTOForAuthorization);
        return new ResponseEntity<>(jwtProvider.generatedToken(user), HttpStatus.OK);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody UserDTOForRegistration userDTOForRegistration){
            return new ResponseEntity<>(userService.addObject(userDTOForRegistration), HttpStatus.CREATED);
    }
}
