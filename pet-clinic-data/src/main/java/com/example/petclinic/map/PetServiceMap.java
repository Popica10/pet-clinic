package com.example.petclinic.map;

import com.example.petclinic.model.Pet;
import com.example.petclinic.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
}