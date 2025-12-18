package com.example.demo.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //runtime exception
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethod(MethodArgumentNotValidException mex){
        
        Map<String, String> error = new HashMap<>();

        mex.getBindingResult().getFieldErrors().forEach(fieldError -> 
            error.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
