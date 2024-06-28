package com.fleming99.StylistSG.core.usecases;

import java.util.List;

public interface EntityService<T> {

    List<T> findAll();

    T findById(int theId);

    T save(T t);

    void deleteById(int theId);
}
