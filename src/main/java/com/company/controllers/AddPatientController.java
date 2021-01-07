package com.company.controllers;

import com.company.model.*;
import com.company.repositories.PatientRepository;
import com.company.repositories.RoleRepository;
import com.company.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

@Controller
public class AddPatientController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PatientRepository patientRepository;

    private String pesel;
    private User user = new User();
    private Patient patient1 = new Patient();
    private Boolean checked = false;
    //private Role role = new Role();


    @GetMapping("/clinic/create-patient/has-pesel")
    public String enterPesel(Model model){
        model.addAttribute("dataReader", new DataReader());
        return "check-pesel";
    }

    @PostMapping("/clinic/create-patient/has-pesel")
    public String checkPeselAndRedirectToNextStage(@ModelAttribute DataReader dataReader, Model model){
        System.out.println("XDDDD");
        System.out.println(dataReader.getData());
        boolean checked = Boolean.parseBoolean(dataReader.getData());
        if(dataReader.getPesel().length() > 0 && checked){
            pesel = dataReader.getPesel();


            //TODO walidacja numeru PESEL


            User usr = userRepository.getUserByPesel(pesel).orElseGet(User::new);
            System.out.println(usr.toString());
            //TODO Tutaj trzeba dalej dorobić

            if (!(usr.getRole() == null)){
                return "redirect:/clinic/create-patient/already-exists";
            }
            else {

                this.user.setPesel(pesel);
                return "redirect:/clinic/create-patient/enter-data-with-pesel";

            }
        }
        else if(checked){
            return "redirect:/clinic/create-patient/has-pesel";
        }
        else{
            return "redirect:/clinic/create-patient/enter-data-without-pesel";
        }

    }

    @GetMapping("/clinic/create-patient/already-exists")
    public String userAlreadyExists(Model model){
        return "user-already-exists";
    }

    @GetMapping("/clinic/create-patient/enter-data-with-pesel")
    public String enterPatientsData(Model model){
        model.addAttribute("patient",new Patient());
        return "enter-patients-data";
    }

    @PostMapping("/clinic/create-patient/enter-data-with-pesel")
    public String checkAndAddPatientsData(@ModelAttribute Patient patient, Model model){
        this.patient1 = patient;
        this.user.setPesel(this.pesel);
        this.user.setRole(roleRepository.getRolesById(2));
        this.user.setUsername(this.patient1.getFirstName().substring(0,3) + this.patient1.getLastName().substring(0,3));
        this.user.setPassword(""+this.patient1.getFirstName().charAt(0) + this.patient1.getLastName().charAt(0) + user.getPesel());
        return "redirect:/admin";
    }

    @GetMapping("/clinic/create-patient/enter-data-without-pesel")
    public String enterPatientDataNoPesel(Model model){
        System.out.println("GET");
        model.addAttribute("patient",new Patient());
        return "enter-patients-data-no-pesel";
    }

    @PostMapping("/clinic/create-patient/enter-data-without-pesel")
    public String checkAndAddPatientDataNoPesel(@ModelAttribute Patient patient , Model model){
        System.out.println("POST");
        this.patient1 = patient;
        this.user.setRole(roleRepository.getRolesById(2));
        this.user.setUsername(this.patient1.getFirstName().substring(0,4) + this.patient1.getLastName().substring(0,3));
        this.user.setPassword(""+this.patient1.getFirstName().charAt(0) + this.patient1.getLastName().charAt(0) + patient.getPhoneNumber());
        System.out.println(user.toString());
        this.patient1.setNotificationStatus(true);
        userRepository.save(this.user);
        this.patient1.setUserId(this.user);
        patientRepository.save(this.patient1);

        return "redirect:/admin";
    }
}
