package com.example.redwardpetclinic.repositories;

import com.example.redwardpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by r.edward on {17/08/2023}
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {}