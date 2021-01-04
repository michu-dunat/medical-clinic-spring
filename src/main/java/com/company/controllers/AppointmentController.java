package com.company.controllers;

import com.company.model.Appointment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

    @GetMapping("/appointments")
    public String greetingForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointments";
    }

    @PostMapping("/result")
    public String greetingSubmit(@ModelAttribute Appointment appointment, Model model) {
        model.addAttribute("appointment", appointment);
        return "result";
    }
}
