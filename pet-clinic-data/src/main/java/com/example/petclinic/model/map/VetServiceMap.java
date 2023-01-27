package com.example.petclinic.model.map;

import com.example.petclinic.model.Vet;
import com.example.petclinic.model.service.VetService;
import org.springframework.stereotype.Component;

@Component
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
}
