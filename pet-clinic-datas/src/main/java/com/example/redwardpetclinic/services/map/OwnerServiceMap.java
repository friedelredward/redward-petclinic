package com.example.redwardpetclinic.services.map;

import com.example.redwardpetclinic.model.Owner;
import com.example.redwardpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * Created by r.edward on {08/08/2023}
 * we no longer extend from CRUDRepo but from OWNERService
 * since it(OWNERService) extends CRUD Service directly
 */
//public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
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
        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Owner foundOwner= null;
//        new ArrayList<Owner>(map.values()).stream().filter(); ;
        Optional<Owner> optionalfind = map.values().stream()
                .filter(owner -> owner.getLastName().equals(lastName)).findFirst();
        if(optionalfind.isPresent()){
            foundOwner= optionalfind.get();
        }
        return foundOwner;
    }
}
