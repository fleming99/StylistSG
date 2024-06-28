package com.fleming99.StylistSG.application;

import com.fleming99.StylistSG.core.dao.StylistEmployeeDAO;
import com.fleming99.StylistSG.core.dao.StylistRoleDAO;
import com.fleming99.StylistSG.core.entities.StylistEmployee;
import com.fleming99.StylistSG.core.entities.StylistRole;
import com.fleming99.StylistSG.core.usecases.EntityService;
import com.fleming99.StylistSG.core.usecases.UserService;
import com.fleming99.StylistSG.core.validation.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService<StylistEmployee> {

    private final EntityService<StylistEmployee> stylistEmployeeEntityService;
    private final StylistRoleDAO roleDAO;
    private final StylistEmployeeDAO stylistEmployeeDAO;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(EntityService<StylistEmployee> stylistEmployeeEntityService, StylistRoleDAO roleDAO, StylistEmployeeDAO stylistEmployeeDAO, BCryptPasswordEncoder passwordEncoder) {
        this.stylistEmployeeEntityService = stylistEmployeeEntityService;
        this.roleDAO = roleDAO;
        this.stylistEmployeeDAO = stylistEmployeeDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public StylistEmployee findByEmail(String email) {
        return stylistEmployeeDAO.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        StylistEmployee stylistEmployee = stylistEmployeeDAO.findByEmail(email);

        if (stylistEmployee == null){
            System.out.println("o problema está aqui");
            throw new UsernameNotFoundException("Invalid email or password");
        }

        return new org.springframework.security.core.userdetails.User(stylistEmployee.getStylistEmail(), stylistEmployee.getStylistPassword(), mapRolesToAuthorities(stylistEmployee.getUserRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<StylistRole> roles) {
        return roles.stream().map(role -> new
                SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
