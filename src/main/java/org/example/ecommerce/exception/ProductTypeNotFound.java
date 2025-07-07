package org.example.ecommerce.exception;

import org.example.ecommerce.dto.Product;

public class ProductTypeNotFound extends RuntimeException{
    public ProductTypeNotFound(String message){
        super(message);
    }
}
