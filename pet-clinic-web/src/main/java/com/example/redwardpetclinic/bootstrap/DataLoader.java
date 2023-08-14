package com.example.redwardpetclinic.bootstrap;

import com.example.redwardpetclinic.model.Owner;
import com.example.redwardpetclinic.model.PetType;
import com.example.redwardpetclinic.model.Vet;
import com.example.redwardpetclinic.services.OwnerService;
import com.example.redwardpetclinic.services.PetTypeService;
import com.example.redwardpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by r.edward on {10/08/2023}
 */
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

/*lets inject this the spring way!!
remember to annotate with serve the implementation ...ServiceMap

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }*/

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType petType= new PetType();
        petType.setName("dog");
        PetType savedPetType= petTypeService.save(petType);// we save ref for later

        PetType petTypeCat= new PetType();
        petType.setName("cat");
        PetType savedCatType= petTypeService.save(petTypeCat);

        Owner o1= new Owner();
        o1.setFirstName("bill");
        o1.setId(1L);
        ownerService.save(o1);

        Owner o2= new Owner();
        o2.setFirstName("Bob");
        o2.setId(2L);
        ownerService.save(o2);

        Vet v1= new Vet();
        v1.setFirstName("Lucky");
        v1.setLastName("Friedel");
        v1.setId(1L);
        vetService.save(v1);

        Vet v2= new Vet();
        v2.setFirstName("Maromo");
        v2.setLastName("MaromoFamily");
        v2.setId(2L);
        vetService.save(v2);

        System.out.println("loaded Owners and Vets");
    }
}
