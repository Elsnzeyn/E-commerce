package org.example.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.dto.Cart;
import org.example.ecommerce.exception.IdNotFound;
import org.example.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    @PostMapping("/cart/add")
    public void addCart(@RequestParam int prodId,@RequestParam int quantity) {
        cartService.addCart(prodId, quantity);
    }
    @GetMapping("/cart")
    public List<Cart> getCartList(){
        return cartService.getCartList();
    }
    @DeleteMapping("/cart")
    public void deleteCart(){
        cartService.clearCart();
    }

}
