package com.example.redwardpetclinic.services.map;

import com.example.redwardpetclinic.model.Pet;
import com.example.redwardpetclinic.services.CrudService;

import java.util.Set;

/**
 * Created by r.edward on {08/08/2023}
 * We could make the abstract implement th interface CRUD and then extend
 */
public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
