package com.company.handlers;

import com.company.model.DataReader;
import com.company.model.Patient;
import com.company.model.User;
import com.company.repositories.PatientRepository;
import com.company.repositories.RoleRepository;
import com.company.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;

public class AddAccountHandler {

    DataReader dataReader;
    Patient patient;
    User user;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    RoleRepository roleRepository;

    public long inputPESEL() {
        return 0;
    }

    public long parsePESEL(String PESEL) {
        long parsedPESEL = Long.getLong(PESEL);
        return parsedPESEL;
    }

    public HashMap<String, String> inputPatientData() {
        return null;
    }

    /*public boolean createAccount(HashMap<String, String> patientDataHashMap, long PESEL) {
        return false;
    }

    public Patient createPatient(HashMap<String, String> patientDataHashMap) {
        return null;
    }

    public User createUser(HashMap<String, String> patientDataHashMap) {
        return null;
    }*/

    public boolean checkIfUserExistsWithGivenPESEL(long PESEL) {
        return false;
    }

}
