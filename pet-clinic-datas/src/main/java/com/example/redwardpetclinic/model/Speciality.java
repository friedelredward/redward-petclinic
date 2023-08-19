package com.example.redwardpetclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Created by r.edward on {14/08/2023}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Specialities")
public class Speciality extends BaseEntity{

    @Column(name = "description") private String description;
}
