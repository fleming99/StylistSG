package com.fleming99.StylistSG.core.dao;

import com.fleming99.StylistSG.core.entities.StylistRole;
import com.fleming99.StylistSG.core.usecases.RoleDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class StylistRoleDAO implements RoleDAO {

    private final EntityManager entityManager;

    public StylistRoleDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public StylistRole findRoleByName(String theRoleName) {

        TypedQuery<StylistRole> typedQuery = entityManager.createQuery("from StylistRole where roleName=:role", StylistRole.class);
        typedQuery.setParameter("role", theRoleName);

        StylistRole role = null;

        try{
            role = typedQuery.getSingleResult();
        }catch (Exception ignored){
        }

        return role;
    }
}
