package com.fleming99.StylistSG.core.dao;

import com.fleming99.StylistSG.core.entities.StylistEmployee;
import com.fleming99.StylistSG.core.usecases.EntityDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class StylistEmployeeDAO implements EntityDAO<StylistEmployee> {

    private final EntityManager entityManager;

    public StylistEmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public StylistEmployee findByEmail(String email) {

        TypedQuery<StylistEmployee> query = entityManager.createQuery("from StylistEmployee where stylistEmail=:email and activeProfile=true", StylistEmployee.class);
        query.setParameter("email",email);

        StylistEmployee stylistEmployee = query.getSingleResult();

        if (stylistEmployee == null){
            throw new RuntimeException("Did not found the employee");
        }

        return stylistEmployee;
    }
}
