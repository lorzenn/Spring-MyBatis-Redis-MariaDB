package com.example.library.books.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
/**
 * This class is holds the @ControllerAdvice annotation that handles all global exceptions
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookIdNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> globalExceptionHandler1(Exception ex) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookIdAlreadyExistException.class)
    public ResponseEntity<CustomErrorResponse> globalExceptionHandler2(Exception ex) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>
                (errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
