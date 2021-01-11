package com.company.services;

import com.company.model.Patient;
import com.company.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {

        var patients = (List<Patient>) patientRepository.findAll();

        return patients;
    }

    public void updatePatientAddress(Patient patient, String address, String city, String postcode){
        patientRepository.updateAddress(patient.getId(), address, city, postcode);
    }
}
