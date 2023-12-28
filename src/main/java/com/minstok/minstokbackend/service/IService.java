package com.minstok.minstokbackend.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface IService<T> {
    List<T> findAll();
    Optional<T> findById(UUID id);
    T save(T entity);
    T update(UUID id, T entity);
    void deleteById(UUID id);
}
