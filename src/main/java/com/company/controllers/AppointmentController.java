package com.company.controllers;

import com.company.MyUserDetailsService;
import com.company.handlers.AppointmentHandler;
import com.company.model.*;
import com.company.repositories.AppointmentRepository;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @Autowired
    private MyUserDetailsService myUserDetailsService;

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
        choice = Integer.parseInt(data.getData());
        return "redirect:/appointments/patient-last-name-input";
    }

    @GetMapping("/patient")
    public String patientPanel(Model model) {
        model.addAttribute("choice", new DataReader());
        model.addAttribute("choice2", choice);
        return "patient-start-view";
    }

    @PostMapping("/patient")
    public String patientChoice(@ModelAttribute DataReader data, Model model) {
        if(data.getData()!=null)
            choice = Integer.parseInt(data.getData());
        else
            choice = 0;

        switch(choice){
            case 1:
            {
                return "redirect:/appointments/doctor-selection";
            }
            case 2:
            {
                return "redirect:/appointments/appointment-selection";
            }
            case 3:
            {
                return "redirect:/appointments/doctor-selection";
            }
            default:
            {
                return "redirect:/home";
            }

        }
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
        if(choice==0)
            return "redirect:/appointments/doctor-selection";
        if(choice == 1)
            return "redirect:/appointments/appointment-selection";
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
        String doctorId = data.getData();
        e = employeeRepository.findEmployeeById(doctorId);
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
        if(d.isBefore(LocalDate.now()))
        {
            badDate = true;
            return "redirect:/appointments/date-selection";
        }
        else
            badDate = false;

        if(appointmentHandler.isAbleToCreateAppointmentOnDate(d, e))
            return "redirect:/appointments/make-appointment";
        else
            return "redirect:/appointments/doctor-selection";
    }

    @GetMapping("/appointments/make-appointment")
    public String makeAppointment(Model model) {
        if(p == null) {
            Authentication getCurrentLoginContext = SecurityContextHolder.getContext().getAuthentication();
            p = myUserDetailsService.getPatientByUser((MyUserDetails) getCurrentLoginContext.getPrincipal());
        }
        List<String> roomNumbers= Arrays.asList("0.1", "0.2", "0.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3");
        Random rand = new Random();
        String randRoomNumber = roomNumbers.get(rand.nextInt(roomNumbers.size()));

        Appointment appointment = new Appointment(randRoomNumber, d, p, e);
        Appointment a = appointmentRepository.save(appointment);
        if(a != null)
            return "redirect:/appointments/success";
        else
            return "redirect:/appointments/failure";
    }

    @GetMapping("/appointments/appointment-selection")
    public String selectAppointment(Model model) {
        if(p == null) {
            Authentication getCurrentLoginContext = SecurityContextHolder.getContext().getAuthentication();
            p = myUserDetailsService.getPatientByUser((MyUserDetails) getCurrentLoginContext.getPrincipal());
        }
        List<Appointment> appointments = appointmentRepository.findAppointmentsByPatientId(p);
        appointments.removeIf(ap -> ap.getDate().isBefore(LocalDate.now()));
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

    @GetMapping("/appointments/delete-appointment")
    public String deleteAppointment(Model model) {
        int amountOfDeletedRows = appointmentRepository.deleteAppointmentById(Integer.parseInt(appointmentIdToBeDeleted));
        if(amountOfDeletedRows>0) {
            return "redirect:/appointments/success";
        }
        else {
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


}
