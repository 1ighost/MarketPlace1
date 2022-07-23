package com.andi.marketplace.service.impl;

import com.andi.marketplace.entities.Customer;
import com.andi.marketplace.repositories.CustomerRepository;
import com.andi.marketplace.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }
}
