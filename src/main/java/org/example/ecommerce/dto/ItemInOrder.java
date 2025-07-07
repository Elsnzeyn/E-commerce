package org.example.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemInOrder {
    private ProductInOrder product;
    private int quantity;
    public void addProduct(ProductInOrder prod){
        this.product = prod;
    }

}
