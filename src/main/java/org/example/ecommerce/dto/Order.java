package org.example.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private int total;
    private ItemInOrder item;
    public void addItem(ItemInOrder itemInOrder){
        this.item = itemInOrder;
    }
    public void addId(ProductInOrder productInOrder){
        this.id = productInOrder.getId();
    }



}
