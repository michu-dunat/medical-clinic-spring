package com.company.controllers;

import com.company.handlers.AppointmentHandler;
import com.company.model.Appointment;
import com.company.model.DataReader;
import com.company.model.Employee;
import com.company.model.Patient;
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
public class AppointmentController {

    @Autowired
    private AppointmentHandler appointmentHandler;

    private Employee e;
    private Patient p = null;
    private LocalDate d;
    private String lastName;
    private String appointmentIdToBeDeleted;
    private int choice = -1;
    private boolean badDate = false;

    @GetMapping("/clinic-worker")
    public String clinicWorkerPanel(Model model) {
        model.addAttribute("boolin", new DataReader());
        return "clinic-worker-start-view";
    }

    @PostMapping("/clinic-worker")
    public String clinicWorkerChoice(@ModelAttribute DataReader data, Model model) {
        if (data.getData() != null)
            choice = Integer.parseInt(data.getData());
        else
            choice = 0;

        switch(choice) {
            case 1:
                return "redirect:/clinic/appointments/patient-last-name-input";
            case 2:
                return "redirect:/clinic/appointments/patient-last-name-input";
            case 3:
                return "redirect:/clinic/create-patient/has-pesel";
            case 4:
                return "redirect:/clinic/edit-patient/patient-last-name-input";
            default:
                return "redirect:/home";
        }
    }

    @GetMapping("/patient")
    public String patientPanel(Model model) {
        model.addAttribute("choice", new DataReader());
        model.addAttribute("choice2", choice);
        return "patient-start-view";
    }

    @PostMapping("/patient")
    public String patientChoice(@ModelAttribute DataReader data, Model model) {
        if (data.getData() != null)
            choice = Integer.parseInt(data.getData());
        else
            choice = 0;

        switch (choice) {
            case 1: {
                return "redirect:/appointments/doctor-selection";
            }
            case 2: {
                return "redirect:/appointments/appointment-selection";
            }
            case 3: {
                return "redirect:/appointments/view";
            }
            default: {
                return "redirect:/home";
            }

        }
    }

    @GetMapping("/clinic/appointments/patient-last-name-input")
    public String inputPatientLastName(Model model) {
        model.addAttribute("lastName", new DataReader());
        return "patient-last-name";
    }

    @PostMapping("/clinic/appointments/patient-last-name-input")
    public String savePatientLastNameAndRedirectToPatientSelection(@ModelAttribute DataReader data, Model model) {
        lastName = data.getData();
        return "redirect:/clinic/appointments/patient-selection";
    }

    @GetMapping("/clinic/appointments/patient-selection")
    public String selectPatient(Model model) {
        List<Patient> patients = appointmentHandler.browsePatients(lastName);
        model.addAttribute("patients", patients);
        model.addAttribute("selectedPatient", new DataReader());
        return "patients";
    }

    @PostMapping("/clinic/appointments/patient-selection")
    public String savePatientAndRedirectToDoctorSelection(@ModelAttribute DataReader data, Model model) {
        p = appointmentHandler.getPatient(data.getData());

        if (choice == 1)
            return "redirect:/appointments/doctor-selection";
        if (choice == 2)
            return "redirect:/appointments/appointment-selection";
        if (choice == 4)
            return "redirect:/clinic/edit-patient";
        return null;
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
        e = appointmentHandler.getDoctor(data.getData());
        return "redirect:/appointments/date-selection";
    }

    @GetMapping("/appointments/date-selection")
    public String chooseDate(Model model) {
        model.addAttribute("doc", e);
        model.addAttribute("selectedDate", new DataReader());
        model.addAttribute("badDate", badDate);

        return "calendar";
    }

    @PostMapping("/appointments/date-selection")
    public String showEverything(@ModelAttribute DataReader data, Model model) {
        d = LocalDate.parse(data.getData());
        if (d.isBefore(LocalDate.now())) {
            badDate = true;
            return "redirect:/appointments/date-selection";
        } else
            badDate = false;

        if (appointmentHandler.isAbleToCreateAppointmentOnDate(d, e))
            return "redirect:/appointments/make-appointment";
        else
            return "redirect:/appointments/doctor-selection";
    }

    @GetMapping("/appointments/make-appointment")
    public String makeAppointment(Model model) {
        if (p == null)
            p = appointmentHandler.getPatientIfPatientLoggedIn();

        Appointment a = appointmentHandler.saveAppointment(p, e, d);

        if (a != null)
            return "redirect:/appointments/success";
        else
            return "redirect:/appointments/failure";
    }

    @GetMapping("/appointments/appointment-selection")
    public String selectAppointment(Model model) {
        if (p == null)
            p = appointmentHandler.getPatientIfPatientLoggedIn();

        List<Appointment> appointments = appointmentHandler.browseCalendar(p);

        model.addAttribute("appointments", appointments);
        model.addAttribute("selectedAppointment", new DataReader());

        return "patient-appointments-deletion-view";
    }

    @PostMapping("/appointments/appointment-selection")
    public String deleteAppointmentAndRedirectToClinicWorkerView(@ModelAttribute DataReader data, Model model) {
        appointmentIdToBeDeleted = data.getData();
        return "redirect:/appointments/delete-appointment";
    }

    @GetMapping("/appointments/delete-appointment")
    public String deleteAppointment(Model model) {
        int amountOfDeletedRows = appointmentHandler.deleteAppointment(appointmentIdToBeDeleted);

        if (amountOfDeletedRows > 0) {
            return "redirect:/appointments/success";
        } else {
            return "redirect:/appointments/failure";
        }
    }

    @RequestMapping("/appointments/success")
    public String successView(Model model) {
        return "success";
    }

    @RequestMapping("/appointments/failure")
    public String failureView(Model model) {
        return "failure";
    }

    @GetMapping("/appointments/view")
    public String appointmentView(Model model) {
        if (p == null)
            p = appointmentHandler.getPatientIfPatientLoggedIn();

        List<Appointment> appointments = appointmentHandler.browseCalendar(p);
        model.addAttribute("appointments", appointments);

        return "patient-appointments-view";
    }


}
