package com.fleming99.StylistSG.adapters;

import com.fleming99.StylistSG.core.entities.StylistRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StylistRoleRepository extends JpaRepository<StylistRole, Integer> {
}
