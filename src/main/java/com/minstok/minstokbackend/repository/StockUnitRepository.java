package com.minstok.minstokbackend.repository;

import com.minstok.minstokbackend.entity.StockUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StockUnitRepository extends JpaRepository<StockUnit, UUID> {
    // Custom query methods if needed
}
