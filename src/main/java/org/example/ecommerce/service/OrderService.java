package org.example.ecommerce.service;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CartService cartService;
    private final ProductService productService;
    List<Order> orderList = new ArrayList<>();
    public List<Order> placeOrder() {
        if(cartService.checkCart() == null){
            throw new RuntimeException("Cart is empty");
        }
        if(productService.findById(cartService.getProdInCart().getId()).getStock()< cartService.getQuantity()){
            throw new RuntimeException("Cannot place order. Product" +productService.findById(cartService.getProdInCart().getId()).getName()+"only has" +productService.findById(cartService.getProdInCart().getId()).getStock()+ "left in stock. You requested" + cartService.getQuantity());}
        else{
            ProdInCart prodInCart = cartService.getProdInCart();
            ProductInOrder productInOrder = new ProductInOrder();
            productInOrder.add(prodInCart);

            ItemInOrder itemInOrder = new ItemInOrder();
            itemInOrder.addProduct(productInOrder);
            itemInOrder.setQuantity(cartService.getQuantity());

            Order order = new Order();
            order.addItem(itemInOrder);
            order.addId(productInOrder);

            order.setTotal(itemInOrder.getQuantity() * prodInCart.getPrice());
            orderList.add(order);
            cartService.clearCart();

            return orderList;
        }


    }
    public List<Order> getOrder(){
        return orderList;
    }
}
