package com.momentum.automatedwithdrawal.repository;

import com.momentum.automatedwithdrawal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
