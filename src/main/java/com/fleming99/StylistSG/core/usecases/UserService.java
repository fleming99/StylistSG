package com.fleming99.StylistSG.core.usecases;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService<T> extends UserDetailsService {

    T findByEmail(String email);
}
