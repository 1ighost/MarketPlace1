package com.andi.marketplace.service.impl;

import com.andi.marketplace.entities.Customer;
import com.andi.marketplace.entities.Product;
import com.andi.marketplace.repositories.CustomerRepository;
import com.andi.marketplace.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow(()
                -> new RuntimeException("No customer with such id found"));
    }

    @Transactional
    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    @Override
    public List<Product> addToBucket(int customerId, Product product) {
        var theCustomer = this.getById(customerId);
        var bucket = theCustomer.getBucket();
        var wallet = theCustomer.getWallet();
        if(wallet >= product.getPrice()) {
            bucket.add(product);
            wallet = wallet - product.getPrice();
            theCustomer.setWallet(wallet);
        } else {
            throw new RuntimeException("Not enough money in the wallet");
        }
        return bucket;
    }
}
