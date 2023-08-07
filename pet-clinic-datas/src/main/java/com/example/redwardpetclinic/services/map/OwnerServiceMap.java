package com.example.redwardpetclinic.services.map;

import com.example.redwardpetclinic.model.Owner;
import com.example.redwardpetclinic.services.CrudService;

import java.util.Set;

/**
 * Created by r.edward on {08/08/2023}
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        /*because abstract we use super not this !!!!*/
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        /*ojo este id sale del mismo obj, smart*/
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
