package com.fleming99.StylistSG.application;

import com.fleming99.StylistSG.adapters.JobsRepository;
import com.fleming99.StylistSG.core.entities.Jobs;
import com.fleming99.StylistSG.core.usecases.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsServiceImpl implements EntityService<Jobs> {

    private final JobsRepository jobsRepository;

    @Autowired
    public JobsServiceImpl(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    @Override
    public List<Jobs> findAll() {
        return jobsRepository.findAll();
    }

    @Override
    public Jobs findById(int theId) {

        Optional<Jobs> jobs = jobsRepository.findById(theId);

        if (jobs.isEmpty()){
            throw new RuntimeException("Did not found the job by id: " + theId);
        }

        return jobs.get();
    }

    @Override
    public Jobs save(Jobs jobs) {
        return jobsRepository.save(jobs);
    }

    @Override
    public void deleteById(int theId) {
        jobsRepository.deleteById(theId);
    }
}
