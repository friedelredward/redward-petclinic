package com.example.redwardpetclinic.services.map;

import com.example.redwardpetclinic.model.PetType;
import com.example.redwardpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by r.edward on {08/08/2023}
 * We could make the abstract implement th interface CRUD and then extend
 */
/*sin service Spring no lo ve!!!! OJO remember!! thjis is the impl we need in the container!!*/
@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
