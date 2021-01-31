package net.iqbusiness.exception;

import net.iqbusiness.error.RegistrationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RegistrationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> invalidInputHandler(MethodArgumentNotValidException exception){
        RegistrationError registrationError = new RegistrationError(HttpStatus.BAD_REQUEST.value(), exception.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(registrationError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception exception){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        RegistrationError registrationError = new RegistrationError(badRequest.value(), exception.getMessage());
        return  new ResponseEntity<>(registrationError, badRequest);
    }
}
