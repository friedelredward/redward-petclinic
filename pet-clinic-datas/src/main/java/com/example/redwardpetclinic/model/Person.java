package com.example.redwardpetclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by r.edward on {07/08/2023}
 */
@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity {
    @Column(name = "first_name") private String firstName;
    @Column(name = "last_name") private String lastName;
}
