package com.example.petclinic.model.map;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.service.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        return super.map.values().stream().filter(x->x.getLastName().equals(lastName)).findFirst().orElse(null);
    }
}
