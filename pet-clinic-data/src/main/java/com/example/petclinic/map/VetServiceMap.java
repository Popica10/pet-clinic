package com.example.petclinic.map;

import com.example.petclinic.model.Vet;
import com.example.petclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
}