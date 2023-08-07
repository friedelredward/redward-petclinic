package com.example.redwardpetclinic.services;

import com.example.redwardpetclinic.model.Owner;

import java.util.Set;

/**
 * Created by r.edward on {07/08/2023}
 */
public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner save(Owner owner);
    Owner findById(Long id);
    Set<Owner> findAll();

}
