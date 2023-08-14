package com.example.redwardpetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by r.edward on {07/08/2023}
 */
public class Vet extends Person{
    private Set<Specialty> specialties= new HashSet<>();//needs initialization

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
