package org.example.ecommerce.exception;

public class NotAvailableInStock extends RuntimeException{
    public NotAvailableInStock(String message){
        super(message);
    }
}
