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
    private String appointmentIdToBeDeleted;
    private boolean isMakeAppointmentClicked;

    @GetMapping("/clinic-worker")
    public String clinicWorkerPanel(Model model) {
        model.addAttribute("boolin", new DataReader());
        return "clinic-worker-start-view";
    }

    @PostMapping("/clinic-worker")
    public String clinicWorkerChoice(@ModelAttribute DataReader data, Model model) {
        isMakeAppointmentClicked = Boolean.parseBoolean(data.getData());
        return "redirect:/appointments/patient-last-name-input";
    }

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
        model.addAttribute("lastName", new DataReader());
        return "patient-last-name";
    }

    @PostMapping("/appointments/patient-last-name-input")
    public String savePatientLastNameAndRedirectToPatientSelection(@ModelAttribute DataReader data, Model model) {
        lastName = data.getData();
        return "redirect:/appointments/patient-selection";
    }


    @GetMapping("/appointments/patient-selection")
    public String selectPatient(Model model) {
        List<Patient> patients = appointmentHandler.browsePatients(lastName);
        model.addAttribute("patients", patients);
        model.addAttribute("selectedPatient", new DataReader());
        return "patients";
    }

    @PostMapping("/appointments/patient-selection")
    public String savePatientAndRedirectToDoctorSelection(@ModelAttribute DataReader data, Model model) {
        p = patientRepository.findPatientById(Integer.parseInt(data.getData()));
        if(isMakeAppointmentClicked)
            return "redirect:/appointments/doctor-selection";
        else
            return "redirect:/appointments/appointment-selection";
    }

    @GetMapping("/appointments/make-appointment")
    public String makeAppointment(Model model) {
        Appointment appointment = new Appointment("1.06", d, p, e);
        appointmentRepository.save(appointment);
        return "redirect:/user";
    }

    @GetMapping("/appointments/delete-appointment")
    public String deleteAppointment(Model model) {
        int amountOfDeletedRows = appointmentRepository.deleteAppointmentById(Integer.parseInt(appointmentIdToBeDeleted));
        if(amountOfDeletedRows>0) {
            return "redirect:/clinic-worker";
        }
        else {
            return "redirect:/user";
        }
    }

    @GetMapping("/appointments/appointment-selection")
    public String selectAppointment(Model model) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByPatientId(p);
        model.addAttribute("appointments", appointments);
        model.addAttribute("selectedAppointment", new DataReader());

        return "patient-appointments-view";
    }

    @PostMapping("/appointments/appointment-selection")
    public String deleteAppointmentAndRedirectToClinicWorkerView(@ModelAttribute DataReader data, Model model) {
        appointmentIdToBeDeleted = data.getData();
        System.out.println("ID WIZYTY" + appointmentIdToBeDeleted);
        return "redirect:/appointments/delete-appointment";
    }


}
