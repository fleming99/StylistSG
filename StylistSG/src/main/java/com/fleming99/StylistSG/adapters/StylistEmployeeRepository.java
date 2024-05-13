package com.fleming99.StylistSG.adapters;

import com.fleming99.StylistSG.core.entities.StylistEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StylistEmployeeRepository extends JpaRepository<StylistEmployee, Integer> {
}
