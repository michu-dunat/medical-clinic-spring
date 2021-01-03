package com.company.services;

import com.company.repositories.AppointmentRepository;
import com.company.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public List<Appointment> findAll() {

        var appointments = (List<Appointment>) repository.findAll();

        return appointments;
    }
}
