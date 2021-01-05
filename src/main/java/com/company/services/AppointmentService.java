package com.company.services;

import com.company.repositories.AppointmentRepository;
import com.company.model.Appointment;
import com.company.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private EmployeeRepository repo;

    public List<Appointment> findAll() {

        var appointments = (List<Appointment>) repository.findAll();

        return appointments;
    }

    public List<Appointment> findAppointmentByEmployee() {
        var appointments = repository.findAppointmentsByEmployeeId("D001");
        return appointments;
    }
}
