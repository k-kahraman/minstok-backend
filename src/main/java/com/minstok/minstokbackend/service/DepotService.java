package com.minstok.minstokbackend.service;

import com.minstok.minstokbackend.entity.Depot;
import com.minstok.minstokbackend.repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepotService implements IService<Depot> {

    private final DepotRepository depotRepository;

    @Autowired
    public DepotService(DepotRepository depotRepository) {
        this.depotRepository = depotRepository;
    }

    @Override
    public List<Depot> findAll() {
        return depotRepository.findAll();
    }

    @Override
    public Optional<Depot> findById(Long id) {
        return depotRepository.findById(id);
    }

    @Override
    public Depot save(Depot depot) {
        return depotRepository.save(depot);
    }

    @Override
    public Depot update(Long id, Depot depot) {
        return depotRepository.findById(id)
                .map(existingDepot -> {
                    existingDepot.setName(depot.getName());
                    existingDepot.setAddress(depot.getAddress());
                    existingDepot.setNote(depot.getNote());
                    existingDepot.setOwner(depot.getOwner());
                    return depotRepository.save(existingDepot);
                })
                .orElseGet(() -> {
                    depot.setId(id);
                    return depotRepository.save(depot);
                });
    }

    @Override
    public void deleteById(Long id) {
        depotRepository.deleteById(id);
    }
}
