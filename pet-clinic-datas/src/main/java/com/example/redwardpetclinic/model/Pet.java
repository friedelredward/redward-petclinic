package com.example.redwardpetclinic.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Created by r.edward on {07/08/2023}
 */
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{
    /*write type first then with intelij create class*/
    @Column(name = "name") private String name;
    @Column(name = "birthDate") private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
