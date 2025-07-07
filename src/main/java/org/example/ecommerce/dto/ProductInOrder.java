package org.example.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInOrder {
    private int id;
    private String name;
    public void add(ProdInCart prodInCart){
        this.id = prodInCart.getId();
        this.name = prodInCart.getName();
    }
}
