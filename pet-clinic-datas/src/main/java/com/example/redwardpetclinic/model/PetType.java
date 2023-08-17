package com.example.redwardpetclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Created by r.edward on {07/08/2023}
 */
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{

    @Column(name = "name") private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
