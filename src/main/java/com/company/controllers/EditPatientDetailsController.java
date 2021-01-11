package com.company.controllers;

import com.company.handlers.AppointmentHandler;
import com.company.model.DataReader;
import com.company.model.Patient;
import com.company.repositories.PatientRepository;
import com.company.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EditPatientDetailsController {

    @Autowired
    private AppointmentHandler appointmentHandler;

    @Autowired
    private PatientService patientService;

    private Patient p = null;
    private String lastName;

    @GetMapping("/clinic/edit-patient/patient-last-name-input")
    public String inputPatientLastNameEdition(Model model) {
        model.addAttribute("lastName", new DataReader());
        return "patient-last-name-edit";
    }

    @PostMapping("/clinic/edit-patient/patient-last-name-input")
    public String savePatientLastNameAndRedirectToPatientSelectionForEdit(@ModelAttribute DataReader data, Model model) {
        lastName = data.getData();
        return "redirect:/clinic/edit-patient/patient-selection";
    }

    @GetMapping("/clinic/edit-patient/patient-selection")
    public String selectPatient(Model model) {
        List<Patient> patients = appointmentHandler.browsePatients(lastName);
        model.addAttribute("patients", patients);
        model.addAttribute("selectedPatient", new DataReader());
        return "patients-edit";
    }

    @PostMapping("/clinic/edit-patient/patient-selection")
    public String savePatientAndRedirectToPatientEdition(@ModelAttribute DataReader data, Model model) {
        p = appointmentHandler.getPatient(data.getData());
        return "redirect:/clinic/edit-patient";
    }


    @GetMapping("/clinic/edit-patient")
    public String editAddress(Model model) {

        model.addAttribute("patient", p);
        System.out.println(p.toString());
        return "patient-address-edit";
    }

    @PostMapping("/clinic/edit-patient")
    public String showEverything(@ModelAttribute Patient patient, Model model) {
        patientService.updatePatientAddress(p, patient.getAddress(), patient.getCity(), patient.getPostcode());
        return "redirect:/clinic/edit-patient/success";
    }

    @RequestMapping("/clinic/edit-patient/success")
    public String successView(Model model) {
        return "success";
    }
}
