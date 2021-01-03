package com.company.services;

import com.company.repositories.MedicalRecordRepository;
import com.company.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository repository;

    public List<MedicalRecord> findAll() {

        var medicalRecords = (List<MedicalRecord>) repository.findAll();

        return medicalRecords;
    }
}