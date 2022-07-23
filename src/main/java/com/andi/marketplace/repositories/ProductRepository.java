package com.andi.marketplace.repositories;

import com.andi.marketplace.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
