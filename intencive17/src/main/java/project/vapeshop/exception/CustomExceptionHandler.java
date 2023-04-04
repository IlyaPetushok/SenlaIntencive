package project.vapeshop.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handle(NotFoundException notFoundException){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseError error=new ResponseError(notFoundException.getStatus(),notFoundException.getMessage());
        return new ResponseEntity<>(error.toString(),httpHeaders,HttpStatus.NOT_FOUND);
    }
}
