package org.example.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdInCart {
    private int id;
    private String name;
    private int price;
    private String category;
    public void addToCart(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
    }

}
