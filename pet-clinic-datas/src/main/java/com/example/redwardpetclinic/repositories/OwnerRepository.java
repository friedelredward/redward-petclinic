package com.example.redwardpetclinic.repositories;

import com.example.redwardpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by r.edward on {17/08/2023}
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findByLastName(String lastName);/** this will be created by the spring dynamic query methods*/
}
