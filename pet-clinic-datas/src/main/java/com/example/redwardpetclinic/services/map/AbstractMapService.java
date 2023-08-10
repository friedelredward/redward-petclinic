package com.example.redwardpetclinic.services.map;

import com.example.redwardpetclinic.model.BaseEntity;

import java.util.*;

/**
 * Created by r.edward on {08/08/2023}
 * refatored for complex types:
 *
 * @note since we know id it's gonna be a long like we extend it
 *
 * @note2 also for T we know it's always be used with something that is BaseEntity
 * (se when we use T we will have suggested the methos from extended type)
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map= new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    /** this is most likely what jpa does*/
    T save(T object){
        if(object != null ){ //check not null
            if(object.getId() ==null){//chek id not null, if so generate
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }else{//object null
            throw new RuntimeException("Object Cannot be nUll");
        }

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }
/** Deletes found object, ojo lambda */
    void delete(T object){
        map.entrySet().removeIf(entry-> entry.getValue().equals(object));
    }

    private Long getNextId(){//peta la 1a vez asi que iniciamos con 1L para primer caso
        Long nextL=null;
        try {
            nextL= Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e){
            nextL= 1L;
        }
        return nextL;
    }
}
