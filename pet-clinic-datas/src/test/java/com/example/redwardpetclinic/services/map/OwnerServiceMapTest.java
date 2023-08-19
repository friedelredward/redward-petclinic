package com.example.redwardpetclinic.services.map;

import com.example.redwardpetclinic.model.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by r.edward on {19/08/2023}
 * integration testing. since it's a hashmap we can unsed it without
 * havin to mockito the abstract
 */
class OwnerServiceMapTest {
    public static final Long ownerID = 1L;
    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap= new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());//actual implementations

        //we save 1
        Owner owner1= new Owner();
        owner1.setId(ownerID);
        ownerServiceMap.save(owner1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        assertEquals(1, ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {
        assertEquals(ownerID, ownerServiceMap.findById(ownerID).getId());
    }

    @Test
    void saveExistingID() {
        Owner owner2= new Owner();
        owner2.setId(2L);
        Owner savedOwner=ownerServiceMap.save(owner2);
        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void saveWithoutID() {
        Owner owner2= new Owner();
        Owner savedOwner=ownerServiceMap.save(owner2);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        //we add for the setup so we must be sure to delete that 1
        ownerServiceMap.deleteById(ownerID);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerID));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner= new Owner();
        String ownerName = "test";
        owner.setLastName(ownerName);
        ownerServiceMap.save(owner);

        Owner foundOwner= ownerServiceMap.findByLastName(ownerName);

        assertNotNull(foundOwner);
        assertEquals(ownerName, foundOwner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        String ownerName = "foo";

        Owner foundOwner= ownerServiceMap.findByLastName(ownerName);

        assertNull(foundOwner);
    }
}