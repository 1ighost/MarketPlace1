package com.andi.marketplace.service;

import com.andi.marketplace.entities.Customer;
import com.andi.marketplace.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductService {
    void addProduct(Product product);
    List<Product> listAllProducts();
}
