package com.fleming99.StylistSG.core.usecases;

public interface EntityDAO<T> {

    T findByEmail(String email);
}
