package com.example.redwardpetclinic.services.springdatajpa;

import com.example.redwardpetclinic.model.Pet;
import com.example.redwardpetclinic.repositories.PetRepository;
import com.example.redwardpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by r.edward on {17/08/2023}
 */
@Service
@Profile("springdatajpa")
public class PetServiceJPAService implements PetService {
    private final PetRepository petRepository;

    public PetServiceJPAService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets= new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
