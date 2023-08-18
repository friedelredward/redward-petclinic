package com.example.redwardpetclinic.bootstrap;

import com.example.redwardpetclinic.model.*;
import com.example.redwardpetclinic.services.*;
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
    private final VisitService visitService;

/*lets inject this the spring way!!
remember to annotate with serve the implementation ...ServiceMap

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }*/

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtyService specialtyService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;

        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        //if no pet types, load data
        if(petTypeService.findAll().isEmpty()){
            loadData();
        }
    }

    /**
     * Loads mock data by service on each boot
     * */
    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelefone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelefone("1231231234");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
/* compared this but cant see the difference but names yet.
   private void loadData() {
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
        bobsPet.setPetType(savedCatType);//first we handle pettype [the most nested]
        bobsPet.setName("Good Cat");
        bobsPet.setBirthDate(LocalDate.now());
        bobsPet.setOwner(o1); //add owner then add to owner
        o2.getPets().add(bobsPet);


        ownerService.save(o2);

        //bobsPet.save
        Visit catVisit= new Visit();
        catVisit.setPet(bobsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Smelly kitty, BobsCat");

        visitService.save(catVisit);

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
        v2.getSpecialties().add(savedSurgery);
        vetService.save(v2);

        System.out.println("loaded Owners and Vets");
    }*/
}
