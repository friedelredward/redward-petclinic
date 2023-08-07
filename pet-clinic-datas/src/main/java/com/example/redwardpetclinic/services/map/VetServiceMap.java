package com.example.redwardpetclinic.services.map;

import com.example.redwardpetclinic.model.Vet;
import com.example.redwardpetclinic.services.CrudService;

import java.util.Set;

/**
 * Created by r.edward on {08/08/2023}
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
