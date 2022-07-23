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
public class TestDataLoader {
    private final ProductService productService;
    private final CustomerService customerService;
    @PostConstruct
    private void load() {

        Product p1 = new Product().setId(1).setName("cookies").setPrice(2);
        Product p2 = new Product().setId(2).setName("ice cream").setPrice(3);
        Product p3 = new Product().setId(3).setName("sausages").setPrice(4);
        Product p4 = new Product().setId(4).setName("bread").setPrice(2);
        Product p5 = new Product().setId(5).setName("meat").setPrice(3);
        Product p6 = new Product().setId(6).setName("milk").setPrice(5);

        productService.addProduct(p1);
        productService.addProduct(p2);
        productService.addProduct(p3);
        productService.addProduct(p4);
        productService.addProduct(p5);
        productService.addProduct(p6);

        Customer c1 = new Customer()
                .setId(1)
                .setFirstName("Andy")
                .setLastName("Matvijchuk")
                .setWallet(6);

        Customer c2 = new Customer()
                .setId(2)
                .setFirstName("John")
                .setLastName("Doe")
                .setWallet(5);

        customerService.addCustomer(c1);
        customerService.addCustomer(c2);

        customerService.addToBucket(c1.getId(), p2);
        customerService.addToBucket(c2.getId(), p6);


        productService.listAllProducts().forEach(System.out::println);
        customerService.listAllCustomers().forEach(System.out::println);
    }
}
