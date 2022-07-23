package com.andi.marketplace;

import com.andi.marketplace.entities.Customer;
import com.andi.marketplace.entities.Product;
import com.andi.marketplace.service.CustomerService;
import com.andi.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class DataLoader {
    private final ProductService productService;
    private final CustomerService customerService;
    @PostConstruct
    private void load() {
        Customer c1 = new Customer().setId(1).setFirstName("Andy").setLastName("Matvijchuk").setWallet(4);

        Product p1 = new Product().setId(1).setName("cookies").setPrice(2);
        Product p2 = new Product().setId(2).setName("ice cream").setPrice(3);


        customerService.addCustomer(c1);
        productService.addProduct(p1);
        productService.addProduct(p2);

        customerService.listAllCustomers().forEach(System.out::println);
        productService.listAllProducts().forEach(System.out::println);
    }
}