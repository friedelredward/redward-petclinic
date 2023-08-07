package com.example.redwardpetclinic.services;

import com.example.redwardpetclinic.model.Owner;

/**
 * Created by r.edward on {07/08/2023}
 * ass soon as we extend we get an indicator becaus methods are implemented(yellow)
 */
public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
