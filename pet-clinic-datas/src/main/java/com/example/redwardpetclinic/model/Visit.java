package com.example.redwardpetclinic.model;

import java.time.LocalDate;

/**
 * Created by r.edward on {14/08/2023}
 */
public class Visit extends BaseEntity {
    LocalDate date;
    String description;
    Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
