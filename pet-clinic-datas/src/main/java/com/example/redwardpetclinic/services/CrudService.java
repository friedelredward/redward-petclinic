package com.example.redwardpetclinic.services;

import java.util.Set;

/**
 * Created by r.edward on {08/08/2023}
 * generics will be replaced at runtime by injection
 * specified when implemented
 */
public interface CrudService<T, ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}
