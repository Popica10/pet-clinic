package com.example.petclinic.model;

import java.time.LocalDateTime;

public class Pet extends BaseEntity{

    private PetType petType;
    private Owner owner;
    private LocalDateTime birthday;
}
