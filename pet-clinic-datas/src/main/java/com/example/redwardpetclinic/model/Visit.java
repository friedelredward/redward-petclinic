package com.example.redwardpetclinic.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Created by r.edward on {14/08/2023}
 */
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
    @Column(name = "date") private LocalDate date;
    @Column(name = "description") private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

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
