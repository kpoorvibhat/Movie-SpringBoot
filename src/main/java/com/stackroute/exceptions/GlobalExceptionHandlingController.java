package com.stackroute.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlingController {

    @ExceptionHandler(MovieDoesNotExistException.class)
    public ResponseEntity<String> movieNotFound() {
        return new ResponseEntity<String>("Movie Not Found", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<String> movieAlreadyExists() {
        return new ResponseEntity<String>("Movie Already Exists", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DatabaseTemporarilyUnavailableException.class)
    public ResponseEntity<String> databaseUnavailable() {
        return new ResponseEntity<String>("Database Temporarily Unavailable", HttpStatus.CONFLICT);
    }
}
