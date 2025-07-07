package org.example.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.dto.Product;
import org.example.ecommerce.service.CartService;
import org.example.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProducts(@RequestParam String category, @RequestParam int minPrice, @RequestParam int maxPrice){
        return new ResponseEntity<>(productService.getProducts(category, minPrice, maxPrice), HttpStatus.FOUND);
    }


}
