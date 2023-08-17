package com.example.redwardpetclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Created by r.edward on {14/08/2023}
 */
@Entity
@Table(name = "Specialties")
public class Specialty extends BaseEntity{

    @Column(name = "description") private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
