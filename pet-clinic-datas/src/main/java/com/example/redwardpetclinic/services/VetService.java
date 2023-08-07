package com.example.redwardpetclinic.services;

import com.example.redwardpetclinic.model.Vet;

import java.util.Set;

/**
 * Created by r.edward on {07/08/2023}
 */
public interface VetService {
    Vet save(Vet pet);
    Vet findById(Long id);
    Set<Vet> findAll();

}
