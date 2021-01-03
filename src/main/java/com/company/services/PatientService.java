package com.company.services;

import com.company.model.Patient;
import com.company.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<Patient> findAll() {

        var patients = (List<Patient>) repository.findAll();

        return patients;
    }
}
