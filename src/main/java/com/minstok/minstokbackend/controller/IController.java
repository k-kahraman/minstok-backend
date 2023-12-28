package com.minstok.minstokbackend.controller;

import java.util.List;
import java.util.UUID;

public interface IController<T> {
    List<T> getAll();

    T getById(Long id);

    T save(T entity);

    T update(Long id, T entity);

    void delete(Long id);
}

