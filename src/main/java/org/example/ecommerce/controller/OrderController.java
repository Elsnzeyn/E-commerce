package org.example.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.dto.Order;
import org.example.ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/orders/place")
    public ResponseEntity<?> placeOrder(){
        return new ResponseEntity<>(orderService.placeOrder(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(){
        return new ResponseEntity<>(orderService.getOrder(), HttpStatus.ACCEPTED);
    }
}
