package com.example.redwardpetclinic.model;

import java.util.Set;

/**
 * Created by r.edward on {07/08/2023}
 */
public class Owner extends Person{
    private Set<Pet> pets;
    private String address;
    private String city;
    private String telefone;

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
