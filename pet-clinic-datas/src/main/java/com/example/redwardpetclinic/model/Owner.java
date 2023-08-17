package com.example.redwardpetclinic.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by r.edward on {07/08/2023}
 * If we wwanted to add a pet we would need to add some logic to mimic
 * what hibernate does auto.
 */
@Entity
@Table(name = "owners")
public class Owner extends Person{
    /** If an owner gets deleted, delete also the other parts of relation*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") private Set<Pet> pets= new HashSet<>();
    @Column(name = "address") private String address;
    @Column(name = "city") private String city;
    @Column(name = "telefone") private String telefone;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
