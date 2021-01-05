package com.company.controllers;

import com.company.handlers.AppointmentHandler;
import com.company.model.Appointment;
import com.company.model.DataReader;
import com.company.model.Employee;
import com.company.model.Patient;
import com.company.repositories.AppointmentRepository;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentHandler appointmentHandler;

    @Autowired
    private AppointmentRepository appointmentRepository;

    private Employee e;
    private Patient p;
    private LocalDate d;
    private String lastName;

    @GetMapping("/appointments/doctor-selection")
    public String selectDoctor(Model model) {

        List<Employee> doctors = appointmentHandler.browseDoctors();

        model.addAttribute("doctors", doctors);
        model.addAttribute("selectedDoctor", new DataReader());

        return "doctors";
    }

    @PostMapping("/appointments/doctor-selection")
    public String saveDoctorAndRedirectToDateSelection(@ModelAttribute DataReader data, Model model) {
        String doctorId = data.getData();
        e = employeeRepository.findEmployeeById(doctorId);
        return "redirect:/appointments/date-selection";
    }

    @GetMapping("/appointments/date-selection")
    public String chooseDate(Model model) {
        model.addAttribute("doc", e);
        model.addAttribute("selectedDate", new DataReader());

        return "calendar";
    }

    @PostMapping("/appointments/date-selection")
    public String showEverything(@ModelAttribute DataReader data, Model model) {
        d = LocalDate.parse(data.getData());
        if(appointmentHandler.isAbleToCreateAppointmentOnDate(d, e))
            return "redirect:/appointments/success";
        else
            return "redirect:/appointments/doctor-selection";
    }

    @GetMapping("/appointments/patient-last-name-input")
    public String inputPatientLastName(Model model) {
        System.out.println("Get patient last name");
        model.addAttribute("lastName", new DataReader());
        return "patient-last-name";
    }

    @PostMapping("/appointments/patient-last-name-input")
    public String savePatientLastNameAndRedirectToPatientSelection(@ModelAttribute DataReader data, Model model) {
        System.out.println(lastName);
        lastName = data.getData();
        return "redirect:/appointments/patient-selection";
    }


    @GetMapping("/appointments/patient-selection")
    public String selectPatient(Model model) {
        System.out.println("wybor pacjenta");
        List<Patient> patients = appointmentHandler.browsePatients(lastName);
        model.addAttribute("patients", patients);
        model.addAttribute("selectedPatient", new DataReader());
        return "patients";
    }

    @PostMapping("/appointments/patient-selection")
    public String savePatientAndRedirectToDoctorSelection(@ModelAttribute DataReader data, Model model) {
        p = patientRepository.findPatientById(Integer.parseInt(data.getData()));
        return "redirect:/appointments/doctor-selection";
    }

    @GetMapping("/appointments/success")
    public String success(Model model) {
        Appointment appointment = new Appointment("1.06", d, p, e);
        //appointment.setId(10);
        System.out.println(appointment.toString());
        appointmentRepository.save(appointment);
        return "redirect:/user";
    }


}
