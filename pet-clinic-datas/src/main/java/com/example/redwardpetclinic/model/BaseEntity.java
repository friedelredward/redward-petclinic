package com.example.redwardpetclinic.model;

import java.io.Serializable;

/**
 * Created by r.edward on {07/08/2023}
 */
public class BaseEntity implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
