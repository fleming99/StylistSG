package com.fleming99.StylistSG.application;

import com.fleming99.StylistSG.adapters.PaymentDetailsRepository;
import com.fleming99.StylistSG.core.entities.PaymentDetails;
import com.fleming99.StylistSG.core.usecases.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentDetailsServiceImpl implements EntityService<PaymentDetails> {

    private final PaymentDetailsRepository paymentDetailsRepository;

    @Autowired
    public PaymentDetailsServiceImpl(PaymentDetailsRepository paymentDetailsRepository) {
        this.paymentDetailsRepository = paymentDetailsRepository;
    }

    @Override
    public List<PaymentDetails> findAll() {
        return paymentDetailsRepository.findAll();
    }

    @Override
    public PaymentDetails findById(int theId) {

        Optional<PaymentDetails> paymentDetails = paymentDetailsRepository.findById(theId);

        if (paymentDetails.isEmpty()){
            throw new RuntimeException("Did not found the payment detail by id: " + theId);
        }

        return paymentDetails.get();
    }

    @Override
    public PaymentDetails save(PaymentDetails paymentDetails) {
        return paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public void deleteById(int theId) {
        paymentDetailsRepository.deleteById(theId);
    }
}
