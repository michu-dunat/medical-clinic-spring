package com.company.controllers;

import com.company.model.Appointment;
import com.company.model.Employee;
import com.company.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/appointments/doctor-selection")
    public String showDoctors (Model model) {
        var doctors = (List< Employee >) employeeRepository.findAllDoctors();
        model.addAttribute("doctors", doctors);
        model.addAttribute("selectedDoctor", new Employee());

        return "doctors";
    }

    @PostMapping("/appointments/doctor-selection")
    public String chosenDoctor(@ModelAttribute Employee doctor, Model model) {
        String doctorId = doctor.getId();
        var doc = employeeRepository.findEmployeeById(doctorId);
        model.addAttribute("doc", doc);
        model.addAttribute("date", new Date());
        return "calendar";
    }
}
