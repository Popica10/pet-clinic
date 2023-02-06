package com.example.petclinic.service.map;

import com.example.petclinic.model.Pet;
import com.example.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map", "default"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
}
