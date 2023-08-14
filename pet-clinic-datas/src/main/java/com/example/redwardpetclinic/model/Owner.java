package com.example.redwardpetclinic.model;

import java.util.Set;

/**
 * Created by r.edward on {07/08/2023}
 */
public class Owner extends Person{
    Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
