package com.fleming99.StylistSG.application;

import com.fleming99.StylistSG.adapters.CustomerRepository;
import com.fleming99.StylistSG.core.entities.Customer;
import com.fleming99.StylistSG.core.usecases.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements EntityService<Customer> {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int theId) {

        Optional<Customer> customer = customerRepository.findById(theId);

        if (customer.isEmpty()){
            throw new RuntimeException("Did not found the customer by id: " + theId);
        }

        return customer.get();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }
}
