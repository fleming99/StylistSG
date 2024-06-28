package com.fleming99.StylistSG.adapters;

import com.fleming99.StylistSG.core.entities.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType, Integer> {
}
