package com.example.petclinic.model.service;

import com.example.petclinic.model.Pet;
import com.example.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
