package org.example.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IdNotFound.class)
    public ResponseEntity<String> IdNotFound(IdNotFound e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NotAvailableInStock.class)
    public ResponseEntity<String> NotAvailableInStock(NotAvailableInStock e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ProductTypeNotFound.class)
    public  ResponseEntity<String> ProductTypeNotFound(ProductTypeNotFound e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


}
