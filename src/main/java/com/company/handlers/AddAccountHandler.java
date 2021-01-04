package com.company.handlers;

import com.company.model.Employee;
import com.company.model.Patient;
import com.company.model.User;

import java.util.HashMap;

public class AddAccountHandler {

    /*public boolean addPatient(Patient patient) {
        return false;
    }

    public boolean addEmployee(Employee employee) {
        return false;
    }*/

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
