package com.andi.marketplace.service;

import com.andi.marketplace.entities.Customer;
import com.andi.marketplace.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerService {
    Customer getById(int id);
    void addCustomer(Customer customer);
    List<Customer> listAllCustomers();
    List<Product> addToBucket(int customerId, Product product);
}
