package com.example.petclinic.service.map;

import com.example.petclinic.model.PetType;
import com.example.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
}
