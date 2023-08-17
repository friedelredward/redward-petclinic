package com.example.redwardpetclinic.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by r.edward on {07/08/2023}
 */
@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties",
        joinColumns = @JoinColumn(name= "vet_id"),
        inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialties= new HashSet<>();//needs initialization

    public Set<Speciality> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Speciality> specialties) {
        this.specialties = specialties;
    }
}
