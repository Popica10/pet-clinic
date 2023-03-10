package com.example.petclinic.service.map;

import com.example.petclinic.model.Visit;
import com.example.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map", "default"})
public class VisitServiceMap extends AbstractMapService<Visit,Long> implements VisitService {

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getId() == null ||
                visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }
}
