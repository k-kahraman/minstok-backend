package com.minstok.minstokbackend.service;

import com.minstok.minstokbackend.entity.StockUnit;
import com.minstok.minstokbackend.repository.StockUnitRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StockUnitService implements IService<StockUnit> {

    private final StockUnitRepository stockUnitRepository;

    public StockUnitService(StockUnitRepository stockUnitRepository) {
        this.stockUnitRepository = stockUnitRepository;
    }

    @Override
    public List<StockUnit> findAll() {
        return stockUnitRepository.findAll();
    }

    @Override
    public Optional<StockUnit> findById(Long id) {
        return stockUnitRepository.findById(id);
    }

    @Override
    public StockUnit save(StockUnit stockUnit) {
        if (stockUnit.getQrCode() == null || stockUnit.getQrCode().isEmpty()) {
            stockUnit.setQrCode(generateQrCode(stockUnit));
        }
        return stockUnitRepository.save(stockUnit);
    }

    @Override
    public StockUnit update(Long id, StockUnit stockUnit) {
        // Ensure the stock unit exists, then update it
        return stockUnitRepository.findById(id)
                .map(existingStockUnit -> {
                    existingStockUnit.setName(stockUnit.getName());
                    existingStockUnit.setQrCode(stockUnit.getQrCode());
                    existingStockUnit.setNote(stockUnit.getNote());
                    existingStockUnit.setDepot(stockUnit.getDepot());
                    return stockUnitRepository.save(existingStockUnit);
                })
                .orElseGet(() -> {
                    stockUnit.setId(id);
                    return stockUnitRepository.save(stockUnit);
                });
    }

    @Override
    public void deleteById(Long id) {
        stockUnitRepository.deleteById(id);
    }

    private String generateQrCode(StockUnit stockUnit) {
        return stockUnit.getName() + stockUnit.getDepot().getName();
    }
}
