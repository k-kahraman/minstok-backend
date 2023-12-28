package com.minstok.minstokbackend.controller;

import com.minstok.minstokbackend.service.IService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public abstract class BaseEntityController<T> implements IController<T> {
    private final IService<T> service;

    public BaseEntityController(IService<T> service) {
        this.service = service;
    }


    @Override
    @GetMapping
    public List<T> getAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public T getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @Override
    @PostMapping
    public T save(@RequestBody T entity) {
        return service.save(entity);
    }

    @Override
    @PutMapping("/{id}")
    public T update(@PathVariable Long id, @RequestBody T entity) {
        return service.update(id, entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
