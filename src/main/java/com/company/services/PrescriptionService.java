package com.company.services;

import com.company.model.Prescription;
import com.company.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository repository;

    public List<Prescription> findAll() {

        var prescriptions = (List<Prescription>) repository.findAll();

        return prescriptions;
    }

}
