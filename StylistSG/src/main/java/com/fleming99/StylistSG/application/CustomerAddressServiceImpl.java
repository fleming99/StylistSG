package com.fleming99.StylistSG.application;

import com.fleming99.StylistSG.adapters.CustomerAddressRepository;
import com.fleming99.StylistSG.core.entities.CustomerAddress;
import com.fleming99.StylistSG.core.usecases.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerAddressServiceImpl implements EntityService<CustomerAddress> {

    private final CustomerAddressRepository customerAddressRepository;

    @Autowired
    public CustomerAddressServiceImpl(CustomerAddressRepository customerAddressRepository) {
        this.customerAddressRepository = customerAddressRepository;
    }

    @Override
    public List<CustomerAddress> findAll() {
        return customerAddressRepository.findAll();
    }

    @Override
    public CustomerAddress findById(int theId) {

        Optional<CustomerAddress> customerAddress = customerAddressRepository.findById(theId);

        if (customerAddress.isEmpty()){
            throw new RuntimeException("Did not found the address by id: " + theId);
        }

        return customerAddress.get();
    }

    @Override
    public CustomerAddress save(CustomerAddress customerAddress) {
        return customerAddressRepository.save(customerAddress);
    }

    @Override
    public void deleteById(int theId) {
        customerAddressRepository.deleteById(theId);
    }
}
