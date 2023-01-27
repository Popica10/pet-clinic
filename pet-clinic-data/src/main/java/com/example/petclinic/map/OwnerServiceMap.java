package com.example.petclinic.map;

import com.example.petclinic.model.Owner;
import com.example.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        return super.map.values().stream().filter(x->x.getLastName().equals(lastName)).findFirst().orElse(null);
    }
}
