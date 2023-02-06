package com.example.petclinic.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "type_id")//here is not the same shit - because it's unidirectional - just play around with it - I'm curious
    private PetType petType;    // it's only placed for naming convention: by default the key would be "pet_type_id", for joining it isn't mandatory
    @ManyToOne
    @JoinColumn(name = "owner_id")//not only is it not needed for the actual mapping, but also for name too - because it's by default - please verify
    private Owner owner;        // Not mandatory - only for consistency

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
