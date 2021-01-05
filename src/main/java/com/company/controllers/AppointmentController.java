package com.company.controllers;

import com.company.model.Employee;
import com.company.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    private Employee e;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date d;

    @GetMapping("/appointments/doctor-selection")
    public String showDoctors(Model model) {

        var doctors = (List<Employee>) employeeRepository.findAllDoctors();

        model.addAttribute("doctors", doctors);
        model.addAttribute("selectedDoctor", new Employee());

        return "doctors";
    }

    @PostMapping("/appointments/doctor-selection")
    public String chosenDoctor(@ModelAttribute Employee doctor, Model model) {
        String doctorId = doctor.getId();
        var doc = employeeRepository.findEmployeeById(doctorId);
        e = doc;
        return "redirect:/appointments/date-selection";
    }

    @GetMapping("/appointments/date-selection")
    public String pickDate(Model model) {
        model.addAttribute("doc", e);
        model.addAttribute("date", new Date());

        return "calendar";
    }

    @PostMapping("/appointments/date-selection")
    public String showEverything(@ModelAttribute Date date, Model model) {
        d = date;
        System.out.println(d);
        return "redirect:/user";
    }

    /*
    @GetMapping("/appointments/term-selection")
    public String chosenTerm(Model model) {

        model.addAttribute("date", new Date());
        return "calendar";
    }
    */
}
