package com.example.petclinic.model.map;

import com.example.petclinic.model.Pet;
import com.example.petclinic.model.service.PetService;
import org.springframework.stereotype.Component;

@Component
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
}
