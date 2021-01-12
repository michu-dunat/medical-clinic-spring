package com.company.controllers;

import com.company.factories.PatientFactory;
import com.company.handlers.AddAccountHandler;
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
import com.company.factories.UserFactory;
import java.time.LocalDate;

@Controller
public class AddPatientController {

    @Autowired
    private AddAccountHandler addAccountHandler;

    private String pesel;
    private User user = UserFactory.createDummyUser();
    private Patient patient1 = PatientFactory.createPatientForNewAccount();
    private boolean invalidData = false;
    private boolean invalidBirthDate = false;

    @GetMapping("/clinic/create-patient/has-pesel")
    public String inputPesel(Model model){
        model.addAttribute("dataReader", new DataReader());
        return "inputPESEL";
    }

    @PostMapping("/clinic/create-patient/has-pesel")
    public String validatePesel(@ModelAttribute DataReader dataReader, Model model){
        boolean checked = Boolean.parseBoolean(dataReader.getData());

        if(dataReader.getPesel().length() > 0 && checked){
            pesel = addAccountHandler.validate(dataReader.getPesel());
            if (addAccountHandler.checkIfUserExistsWithGivenPESEL(pesel)){
                return "redirect:/clinic/create-patient/already-exists";
            }else {
                user.setPesel(pesel);
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
        System.out.println(patient1.toString());
        model.addAttribute("invalidBirthDate", invalidBirthDate);
        model.addAttribute("invalidData", invalidData);
        model.addAttribute("patient", patient1);

        return "enter-patients-data";
    }

    @PostMapping("/clinic/create-patient/enter-data-with-pesel")
    public String inputPatientData(@ModelAttribute Patient patient, Model model) throws Exception {
        this.patient1 = patient;
        this.patient1.setNotificationStatus(true);
        //this.user.setPesel(this.pesel);
        if (patient1.getFirstName().isEmpty() || patient1.getLastName().isEmpty() || patient1.getBirthDate() == null || patient1.getCity().isEmpty() || patient1.getPostcode().isEmpty() || patient1.getPhoneNumber().isEmpty()){
            invalidData = true;
            invalidBirthDate = false;
        }
        else if(patient1.getBirthDate().isAfter(LocalDate.now())){
            invalidBirthDate = true;
            invalidData = false;
        }
        else{
            this.invalidData = false;
            this.invalidBirthDate = false;
        }
        if(!(invalidBirthDate || invalidData)) {
            boolean saveAccountStatus = addAccountHandler.createAccount(this.patient1, this.user);
            if (saveAccountStatus) {
                patient1 = PatientFactory.createPatientForNewAccount();
                user = UserFactory.createDummyUser();
                return "redirect:/appointments/success";
            }
            else return "redirect:/appointments/failure";

        }else {
            return "redirect:/clinic/create-patient/enter-data-with-pesel";
        }
    }

    @GetMapping("/clinic/create-patient/enter-data-without-pesel")
    public String enterPatientDataNoPesel(Model model){
        model.addAttribute("patient", patient1);
        model.addAttribute("invalidData", invalidData);
        model.addAttribute("invalidBirthDate", invalidBirthDate);
        return "enter-patients-data-no-pesel";
    }

    @PostMapping("/clinic/create-patient/enter-data-without-pesel")
    public String inputPatientDataNoPesel(@ModelAttribute Patient patient , Model model) throws Exception {
        this.patient1 = patient;
        this.patient1.setNotificationStatus(true);
        System.out.println(patient1.toString());
        if (patient1.getFirstName().isEmpty() || patient1.getLastName().isEmpty() || patient1.getBirthDate() == null || patient1.getCity().isEmpty() || patient1.getPostcode().isEmpty() || patient1.getPhoneNumber().isEmpty()){
            invalidData = true;
            invalidBirthDate = false;
        }
        else if(patient1.getBirthDate().isAfter(LocalDate.now())){
            invalidBirthDate = true;
            invalidData = false;
        }
        else{
            this.invalidData = false;
            this.invalidBirthDate = false;
        }

        if(!(invalidBirthDate || invalidData)) {
            boolean saveAccountStatus = addAccountHandler.createAccount(this.patient1, this.user);
            if (saveAccountStatus) {
                patient1 = PatientFactory.createPatientForNewAccount();
                user = UserFactory.createDummyUser();
                return "redirect:/appointments/success";
            }
            else return "redirect:/appointments/failure";
        }
        else {
            return "redirect:/clinic/create-patient/enter-data-without-pesel";
        }
    }
}
