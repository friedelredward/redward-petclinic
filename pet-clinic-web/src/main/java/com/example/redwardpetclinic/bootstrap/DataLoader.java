package com.example.redwardpetclinic.bootstrap;

import com.example.redwardpetclinic.model.*;
import com.example.redwardpetclinic.services.OwnerService;
import com.example.redwardpetclinic.services.PetTypeService;
import com.example.redwardpetclinic.services.SpecialtyService;
import com.example.redwardpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by r.edward on {10/08/2023}
 */
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

/*lets inject this the spring way!!
remember to annotate with serve the implementation ...ServiceMap

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }*/

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;

        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        //we save these because we need them with id when we add them to
//        bigger entity
        PetType petType= new PetType();
        petType.setName("dog");
        PetType savedPetType= petTypeService.save(petType);// we save ref for later

        PetType petTypeCat= new PetType();
        petType.setName("cat");
        PetType savedCatType= petTypeService.save(petTypeCat);

        Specialty radiology= new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology= specialtyService.save(radiology);
        Specialty dentistry= new Specialty();
        radiology.setDescription("dentistry");
        Specialty savedDentistry= specialtyService.save(dentistry);
        Specialty surgery= new Specialty();
        radiology.setDescription("surgery");
        Specialty savedSurgery= specialtyService.save(surgery);

        Owner o1= new Owner();
        o1.setFirstName("bill");
        o1.setId(1L);
        o1.setAddress("Miami etc");
        o1.setCity("miami city");
        o1.setTelefone("00000000000");

        Pet bilsPet= new Pet();
        bilsPet.setPetType(savedPetType);//first we handle pettype [the most nested]
        bilsPet.setName("Good DOG");
        bilsPet.setBirthDate(LocalDate.now());
        bilsPet.setOwner(o1); //add owner then add to owner
        o1.getPets().add(bilsPet);
        //salvamos el owner al final
        ownerService.save(o1);



        Owner o2= new Owner();
        o2.setFirstName("Bob");
        o2.setId(2L);
        o2.setAddress("Viena");
        o2.setCity("Viena city");
        o2.setTelefone("000000000021");

        Pet bobsPet= new Pet();
        bobsPet.setPetType(petTypeCat);//first we handle pettype [the most nested]
        bobsPet.setName("Good Cat");
        bobsPet.setBirthDate(LocalDate.now());
        bobsPet.setOwner(o1); //add owner then add to owner
        o2.getPets().add(bobsPet);

        ownerService.save(o2);

        Vet v1= new Vet();
        v1.setFirstName("Lucky");
        v1.setLastName("Friedel");
        v1.setId(1L);
        v1.getSpecialties().add(savedRadiology);
        vetService.save(v1);

        Vet v2= new Vet();
        v2.setFirstName("Maromo");
        v2.setLastName("MaromoFamily");
        v2.setId(2L);
        vetService.save(v2);
        v2.getSpecialties().add(savedSurgery);
        System.out.println("loaded Owners and Vets");
    }
}
