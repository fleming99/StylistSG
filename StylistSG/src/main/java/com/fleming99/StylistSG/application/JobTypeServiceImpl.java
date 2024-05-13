package com.fleming99.StylistSG.application;

import com.fleming99.StylistSG.adapters.JobTypeRepository;
import com.fleming99.StylistSG.core.entities.JobType;
import com.fleming99.StylistSG.core.usecases.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTypeServiceImpl implements EntityService<JobType> {

    private final JobTypeRepository jobTypeRepository;

    @Autowired
    public JobTypeServiceImpl(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    @Override
    public List<JobType> findAll() {
        return jobTypeRepository.findAll();
    }

    @Override
    public JobType findById(int theId) {

        Optional<JobType> jobType = jobTypeRepository.findById(theId);

        if (jobType.isEmpty()){
            throw new RuntimeException("Did not found the job type by id: " + theId);
        }

        return jobType.get();
    }

    @Override
    public JobType save(JobType jobType) {
        return jobTypeRepository.save(jobType);
    }

    @Override
    public void deleteById(int theId) {
        jobTypeRepository.deleteById(theId);
    }
}
