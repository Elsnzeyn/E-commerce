package org.example.ecommerce.service;


import lombok.RequiredArgsConstructor;
import org.example.ecommerce.dto.Product;
import org.example.ecommerce.exception.ProductTypeNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductService {
    List<Product> products = new ArrayList<>();

    public boolean addProduct(Product product){
      return products.add(product);
   }
   public List<Product> getProducts(String category, int minPrice, int maxPrice){
     List<Product> filteredProducts = new ArrayList<>();
     for(Product product: products){
        if(product.getCategory().equals(category) && product.getPrice() >= minPrice && product.getPrice() <= maxPrice){
           filteredProducts.add(product);
        }
        else{
            throw new ProductTypeNotFound("This Type of product is not available");
        }
     }return filteredProducts;
   }
   public Product findById(int id){
        for(Product product: products){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
   }

}

