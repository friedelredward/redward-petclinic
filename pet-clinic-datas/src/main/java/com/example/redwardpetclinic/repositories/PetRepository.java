package com.example.redwardpetclinic.repositories;

import com.example.redwardpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by r.edward on {17/08/2023}
 */
public interface PetRepository extends CrudRepository<Pet, Long> {}
