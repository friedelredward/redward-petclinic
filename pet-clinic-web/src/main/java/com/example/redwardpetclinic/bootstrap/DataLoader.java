package com.example.redwardpetclinic.bootstrap;

import com.example.redwardpetclinic.model.Owner;
import com.example.redwardpetclinic.model.Vet;
import com.example.redwardpetclinic.services.map.OwnerServiceMap;
import com.example.redwardpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by r.edward on {10/08/2023}
 */
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;

    public DataLoader() {
        ownerServiceMap = new OwnerServiceMap();
        vetServiceMap = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner o1= new Owner();
        o1.setFirstName("bill");
        o1.setId(1L);
        ownerServiceMap.save(o1);

        Owner o2= new Owner();
        o2.setFirstName("Bob");
        o2.setId(2L);
        ownerServiceMap.save(o2);

        Vet v1= new Vet();
        v1.setFirstName("Lucky");
        v1.setId(1L);
        vetServiceMap.save(v1);

        Vet v2= new Vet();
        v2.setFirstName("Maromo");
        v2.setId(2L);
        vetServiceMap.save(v2);

        System.out.println("loaded Owners and Vets");
    }
}
