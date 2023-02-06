package com.example.petclinic.service.map;

import com.example.petclinic.model.Vet;
import com.example.petclinic.service.SpecialtyService;
import com.example.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map", "default"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet object) {
        if (object != null){
            if (object.getSpecialties().size() > 0){
                object.getSpecialties().forEach(specialty -> {
                    if (specialty.getId() == null){
                        specialty.setId(specialtyService.save(specialty).getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }
}
