package project.vapeshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UnAuthorizationException extends ResponseStatusException {

    public UnAuthorizationException(HttpStatus status, String reason) {
        super(status, reason);
    }
}
