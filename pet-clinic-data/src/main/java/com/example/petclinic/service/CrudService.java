package com.example.petclinic.service;

import com.example.petclinic.model.BaseEntity;

import java.util.Set;

public interface CrudService<T extends BaseEntity,ID extends Long> {
    T findById(ID id);
    T save(T object);
    Set<T> findAll();
    void delete(T object);
    void deleteById(ID id);
}
