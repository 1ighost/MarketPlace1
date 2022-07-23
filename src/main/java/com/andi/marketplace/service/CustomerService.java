package com.andi.marketplace.service;

import com.andi.marketplace.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerService {
    void addCustomer(Customer customer);
    List<Customer> listAllCustomers();
}
