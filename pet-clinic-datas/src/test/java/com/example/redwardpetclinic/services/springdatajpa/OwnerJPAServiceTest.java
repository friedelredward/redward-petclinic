package com.example.redwardpetclinic.services.springdatajpa;

import com.example.redwardpetclinic.model.Owner;
import com.example.redwardpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by r.edward on {19/08/2023}
 * we could have a context so db spins up and
 * we also test the persistence layer(JPA),
 * **but** would be much slower testing.
 * These are CRUD mocked test (without the request to the DB)
 */
@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {
    public static final String OWNERNAME = "test";
    /*no access modifiyer needed actually*/
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerJPAService service;

    Owner owner= new Owner();
    @BeforeEach
    void setUp() {
        //moks already injected with annotation so no
        //further init is necesarry
        owner.setId(1L);
        owner.setLastName(OWNERNAME);
    }

    @Test
    void findAll() {
        Owner owner2= new Owner();
        owner.setId(2L);
        Set<Owner> list = new HashSet<>(asList(owner, owner2));

        when(ownerRepository.findAll()).thenReturn(list);

        Set<Owner> foundOwners= service.findAll();

        assertEquals(2, foundOwners.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findAllNone() {
        Set<Owner> list= new HashSet<>();

        when(ownerRepository.findAll()).thenReturn(list);

        Set<Owner> foundOwners= service.findAll();

        assertEquals(0, foundOwners.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong()))
                .thenReturn(Optional.of(owner));

        Owner foundOwner= service.findById(1L);

        assertNotNull(foundOwner);
        assertEquals(1L, foundOwner.getId());
        verify(ownerRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong()))
                .thenReturn(Optional.empty());

        Owner foundOwner= service.findById(1L);

        assertNull(foundOwner);
        verify(ownerRepository, times(1)).findById(anyLong());
    }

    @Test
    void save() {
        when(ownerRepository.save(any(Owner.class))).thenReturn(owner);

        Owner owner1= service.save(owner);

        assertNotNull(owner1);
        assertEquals(owner, owner1);
        verify(ownerRepository, times(1)).save(any(Owner.class));
    }

    @Test
    void delete() {
        service.delete(owner);

        verify(ownerRepository, times(1)).delete(any(Owner.class));
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString()))
                .thenReturn(Optional.of(owner));

        Owner foundOwner= service.findByLastName(OWNERNAME);

        assertEquals(OWNERNAME, foundOwner.getLastName());
        verify(ownerRepository).findByLastName(anyString());
    }
}