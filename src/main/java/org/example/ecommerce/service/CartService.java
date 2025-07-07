package org.example.ecommerce.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.dto.Cart;
import org.example.ecommerce.dto.ProdInCart;
import org.example.ecommerce.dto.Product;
import org.example.ecommerce.exception.IdNotFound;
import org.example.ecommerce.exception.NotAvailableInStock;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    List<Cart> cartList = new ArrayList<>();
    private final ProductService productService;
    public void addCart(int prodId, int quantity) {

        Product product = productService.findById(prodId);
        if (prodId != product.getId())
            throw new IdNotFound("this id is not available");
        if (quantity > product.getStock()) {
            throw new NotAvailableInStock("that much product is not available in stock, just" + product.getStock()+"is available");
        }

        for(Cart excistingCart: cartList){
            if(excistingCart.getProduct().getId() == prodId){
                excistingCart.setQuantity(excistingCart.getQuantity() + quantity);
            }
        }
        ProdInCart prodInCart = new ProdInCart();
        prodInCart.addToCart(product);

        Cart cart = new Cart();
        cart.addProduct(prodInCart);
        cart.setQuantity(quantity);
        cartList.add(cart);
        product.setStock(product.getStock()-quantity);

    }
    public List<Cart> getCartList() {
        return cartList;
    }
    public void clearCart(){
        cartList.clear();
    }
    public List<Cart> checkCart(){
        for(Cart cart: cartList){
            if(cart != null)
                return cartList;
        }
        return null;
    }
    public ProdInCart getProdInCart(){
        for(Cart cart:cartList)
            return cart.getProduct();
        return null;
    }
    public int getQuantity(){
        for(Cart cart:cartList){
            return cart.getQuantity();
        }
        return 0;

    }

}
