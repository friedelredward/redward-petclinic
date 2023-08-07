package com.example.redwardpetclinic.services;

import com.example.redwardpetclinic.model.Pet;

import java.util.Set;

/**
 * Created by r.edward on {07/08/2023}
 */
public interface PetService {
    Pet save(Pet pet);
    Pet findById(Long id);
    Set<Pet> findAll();

}
