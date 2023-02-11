package com.example.petclinic.service.springdatajpa;

import com.example.petclinic.model.Owner;
import com.example.petclinic.repository.OwnerRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OwnerSDJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerSDJpaService ownerSDJpaService;
    private AutoCloseable closeable;
    private Owner owner;
    private final Long ownerId = 1L;
    private final String ownerName = "Popica";


    @BeforeEach
    void initService() {
        closeable = MockitoAnnotations.openMocks(this);
        owner = Owner.builder().id(ownerId).lastName(ownerName).build();
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(ownerId)).thenReturn(Optional.of(owner));
        Owner foundOwner = ownerSDJpaService.findById(ownerId);

        assertNotNull(foundOwner);
        assertEquals(foundOwner.getId(), ownerId);
    }

    @Test
    void findByIdNotExisting() {
        when(ownerRepository.findById(ownerId)).thenReturn(Optional.empty());
        Owner foundOwner = ownerSDJpaService.findById(ownerId);

        assertNull(foundOwner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(Owner.builder().build());

        Owner savedOwner = ownerSDJpaService.save(owner);
        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void findAll() {
        Owner owner1 = Owner.builder().build();
        Owner owner2 = Owner.builder().build();
        Set<Owner> ownerSet = new HashSet<>(Arrays.asList(owner1, owner2));

        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> ownerSetReturned = ownerSDJpaService.findAll();

        assertEquals(ownerSetReturned.size(), 2);
        verify(ownerRepository).findAll();
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);

        verify(ownerRepository).delete(owner);
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(ownerId);

        verify(ownerRepository).deleteById(ownerId);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(ownerName)).thenReturn(Optional.of(owner));

        Owner returnedOwner = ownerSDJpaService.findByLastName(ownerName);

        assertNotNull(returnedOwner);
        assertEquals(returnedOwner.getId(), ownerId);
        assertEquals(returnedOwner.getLastName(), ownerName);
        verify(ownerRepository).findByLastName(ownerName);
    }
}