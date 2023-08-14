package com.example.redwardpetclinic.services.map;

import com.example.redwardpetclinic.model.Owner;
import com.example.redwardpetclinic.model.Pet;
import com.example.redwardpetclinic.services.OwnerService;
import com.example.redwardpetclinic.services.PetService;
import com.example.redwardpetclinic.services.PetTypeService;
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
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


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
//        return super.save(object); //refactor needed for pet adding logic
        Owner savedOwner= null;
        if(object !=null){
            if (object.getPets() != null){//check pets
                //handle pet  and peetypes ids !
                object.getPets().forEach(pet ->{
                    if (pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){//we save it so we get an ID for the pettype FIRST
                          //thjis pet type w set here for this in the owner object is
//                            already updated with the saved id, check 1 liner;
                            //vare will return the pettype with id != null
                            pet.setPetType(petTypeService.save(pet.getPetType()));

                        }
                    }else{
                        throw  new RuntimeException("PetType is Required");
                    }
                    //we do the same for pet object, remember Owner>Pets>petType
                    if(pet.getId() == null){
                        Pet savedPet= petService.save(pet);//this will give us Id from basclass
                        pet.setId(savedPet.getId());
                    }
                });
            }

        savedOwner = super.save(object);
        }
        return savedOwner;
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
