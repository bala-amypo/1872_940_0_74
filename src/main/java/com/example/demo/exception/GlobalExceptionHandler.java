package com.example.demo.exception; 
import org.springframework.web.bind.annotation.RestControllerAdvice; 
import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.http.ResponseEntity; 
import org.springframework.http.HttpStatus; 
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice 
public class GlobalExceptionHandler{ 
    @ExceptionHandler(ResourceNotFoundException.class) 
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex){ 
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND); 
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethod(MethodArgumentNotValidException mex){
        return 
    }
}
