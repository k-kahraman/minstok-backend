package com.minstok.minstokbackend.repository;

import com.minstok.minstokbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query methods if needed
}
