package com.example.redwardpetclinic.model;

/**
 * Created by r.edward on {14/08/2023}
 */
public class Specialty extends BaseEntity{
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
