package org.example.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private int quantity;
    private ProdInCart product;

   public void addProduct(ProdInCart prodInCart) {
       this.product = prodInCart;
   }

}
