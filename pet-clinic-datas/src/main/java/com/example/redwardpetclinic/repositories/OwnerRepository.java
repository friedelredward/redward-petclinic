package com.example.redwardpetclinic.repositories;

import com.example.redwardpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by r.edward on {17/08/2023}
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
