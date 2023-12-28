package com.minstok.minstokbackend.repository;

import com.minstok.minstokbackend.entity.StockUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StockUnitRepository extends JpaRepository<StockUnit, Long> {
    // Custom query methods if needed
}
