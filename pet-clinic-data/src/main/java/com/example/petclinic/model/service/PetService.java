package com.example.petclinic.model.service;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();

}
