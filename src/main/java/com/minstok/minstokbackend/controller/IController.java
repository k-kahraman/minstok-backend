package com.minstok.minstokbackend.controller;

import java.util.List;
import java.util.UUID;

public interface IController<T> {
    List<T> getAll();

    T getById(UUID id);

    T save(T entity);

    T update(UUID id, T entity);

    void delete(UUID id);
}

