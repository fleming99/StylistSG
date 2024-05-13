package com.fleming99.StylistSG.application;

import com.fleming99.StylistSG.adapters.StylistEmployeeRepository;
import com.fleming99.StylistSG.core.entities.StylistEmployee;
import com.fleming99.StylistSG.core.usecases.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StylistEmployeeServiceImpl implements EntityService<StylistEmployee> {

    private final StylistEmployeeRepository stylistEmployeeRepository;

    @Autowired
    public StylistEmployeeServiceImpl(StylistEmployeeRepository stylistEmployeeRepository) {
        this.stylistEmployeeRepository = stylistEmployeeRepository;
    }

    @Override
    public List<StylistEmployee> findAll() {
        return stylistEmployeeRepository.findAll();
    }

    @Override
    public StylistEmployee findById(int theId) {

        Optional<StylistEmployee> stylistEmployee = stylistEmployeeRepository.findById(theId);

        if (stylistEmployee.isEmpty()){
            throw new RuntimeException("Did not found the stylist by id: " + theId);
        }

        return stylistEmployee.get();
    }

    @Override
    public StylistEmployee save(StylistEmployee stylistEmployee) {
        return stylistEmployeeRepository.save(stylistEmployee);
    }

    @Override
    public void deleteById(int theId) {
        stylistEmployeeRepository.deleteById(theId);
    }
}
