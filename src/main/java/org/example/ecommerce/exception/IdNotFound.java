package org.example.ecommerce.exception;

public class IdNotFound extends RuntimeException{
    public IdNotFound(String message){
        super(message);
    }
}
