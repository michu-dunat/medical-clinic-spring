package com.company.controllers;

import com.company.model.DataReader;
import com.company.model.Employee;
import com.company.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee e;

    @GetMapping("/appointments/doctor-selection")
    public String showDoctors(Model model) {

        var doctors = (List<Employee>) employeeRepository.findAllDoctors();

        model.addAttribute("doctors", doctors);
        model.addAttribute("selectedDoctor", new DataReader());

        return "doctors";
    }

    @PostMapping("/appointments/doctor-selection")
    public String chosenDoctor(@ModelAttribute DataReader data, Model model) {
        String doctorId = data.getData();
        e = employeeRepository.findEmployeeById(doctorId);
        return "redirect:/appointments/date-selection";
    }

    @GetMapping("/appointments/date-selection")
    public String pickDate(Model model) {
        model.addAttribute("doc", e);
        model.addAttribute("selectedDate", new DataReader());

        return "calendar";
    }

    @PostMapping("/appointments/date-selection")
    public String showEverything(@ModelAttribute DataReader data, Model model) {
        System.out.println(data.getData());
        return "redirect:/user";
    }
}
