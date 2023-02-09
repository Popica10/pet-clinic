package com.example.petclinic.service.map;

import com.example.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    private OwnerServiceMap ownerServiceMap;
    private final Long ownerId = 1L;
    private final String ownerLastName = "Popica";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(ownerLastName).build());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);

        assertNotNull(owner);
        assertEquals(owner.getId(), ownerId);
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner savedOwner = ownerServiceMap.save(Owner.builder().id(id).build());

        assertNotNull(savedOwner);
        assertEquals(savedOwner.getId(), id);
    }

    @Test
    void saveNotExistingId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(ownerSet.size(), 1);
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(ownerSet.size(), 0);
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById((ownerId));
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(ownerSet.size(), 0);
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(ownerLastName);

        assertNotNull(owner);
        assertEquals(owner.getId(), ownerId);
    }

    @Test
    void findByLastNameNotExisting() {
        Owner owner = ownerServiceMap.findByLastName("ownerLastName");

        assertNull(owner);
    }
}