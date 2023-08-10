package com.example.redwardpetclinic.bootstrap;

import com.example.redwardpetclinic.model.Owner;
import com.example.redwardpetclinic.model.Vet;
import com.example.redwardpetclinic.services.OwnerService;
import com.example.redwardpetclinic.services.VetService;
import com.example.redwardpetclinic.services.map.OwnerServiceMap;
import com.example.redwardpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by r.edward on {10/08/2023}
 */
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
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
        v1.setId(1L);
        vetService.save(v1);

        Vet v2= new Vet();
        v2.setFirstName("Maromo");
        v2.setId(2L);
        vetService.save(v2);

        System.out.println("loaded Owners and Vets");
    }
}
