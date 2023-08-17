package com.example.redwardpetclinic.services.map;

import com.example.redwardpetclinic.model.Speciality;
import com.example.redwardpetclinic.model.Vet;
import com.example.redwardpetclinic.services.SpecialtyService;
import com.example.redwardpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by r.edward on {08/08/2023}
 */
@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

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
        if(!object.getSpecialties().isEmpty()){
            object.getSpecialties().forEach(specialty->{
                if (specialty.getId() == null){//set id with saved generated id
                    Speciality savedSpecial=specialtyService.save(specialty);
                    specialty.setId(savedSpecial.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
