package com.example.petclinic.service.springdatajpa;

import com.example.petclinic.model.Visit;
import com.example.petclinic.repository.VisitRepository;
import com.example.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        return StreamSupport.stream(visitRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
