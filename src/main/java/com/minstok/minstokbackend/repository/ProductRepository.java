package com.minstok.minstokbackend.repository;

import com.minstok.minstokbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query methods if needed
}
