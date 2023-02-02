package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by jt on 7/25/18.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes.....");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loaded Specialities.....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setCity("New York");
        owner1.setAddress("Street Pavel Bartos");
        owner1.setTelephone("+4-0740-745-542");

        Pet mickyPet = new Pet();
        mickyPet.setName("Reeeeeecsi");
        mickyPet.setBirthDate(LocalDate.now());
        mickyPet.setPetType(savedDogPetType);
        mickyPet.setOwner(owner1);
        owner1.getPets().add(mickyPet);

        ownerService.save(owner1);
        petService.save(mickyPet);//TODO: Is this needed? my approach

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setCity("LA");
        owner2.setAddress("Street Nobody knows");
        owner2.setTelephone("+4-444-333-222");

        Pet fionaPet = new Pet();
        fionaPet.setName("Tiiiiitiiiiii");
        fionaPet.setBirthDate(LocalDate.now());
        fionaPet.setPetType(savedCatPetType);
        fionaPet.setOwner(owner2);
        owner2.getPets().add(fionaPet);

        ownerService.save(owner2);
        petService.save(fionaPet);//TODO: Is this needed? - my approach

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);//TODO: Why don t we have a vet entity into specialities?

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}

