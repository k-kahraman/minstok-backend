package com.minstok.minstokbackend.repository;

import com.minstok.minstokbackend.entity.Depot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepotRepository extends JpaRepository<Depot, Long> {
}
