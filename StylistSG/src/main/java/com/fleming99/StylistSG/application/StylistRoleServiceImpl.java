package com.fleming99.StylistSG.application;

import com.fleming99.StylistSG.adapters.StylistRoleRepository;
import com.fleming99.StylistSG.core.entities.StylistRole;
import com.fleming99.StylistSG.core.usecases.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StylistRoleServiceImpl implements EntityService<StylistRole> {

    private final StylistRoleRepository stylistRoleRepository;

    @Autowired
    public StylistRoleServiceImpl(StylistRoleRepository stylistRoleRepository) {
        this.stylistRoleRepository = stylistRoleRepository;
    }

    @Override
    public List<StylistRole> findAll() {
        return stylistRoleRepository.findAll();
    }

    @Override
    public StylistRole findById(int theId) {

        Optional<StylistRole> stylistRole = stylistRoleRepository.findById(theId);

        if (stylistRole.isEmpty()){
            throw new RuntimeException("Did not found the role by id: " + theId);
        }

        return stylistRole.get();
    }

    @Override
    public StylistRole save(StylistRole stylistRole) {
        return stylistRoleRepository.save(stylistRole);
    }

    @Override
    public void deleteById(int theId) {
        stylistRoleRepository.deleteById(theId);
    }
}
