package com.company.services;

import com.company.model.Payment;
import com.company.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public List<Payment> findAll() {

        var payments = (List<Payment>) repository.findAll();

        return payments;
    }
}
