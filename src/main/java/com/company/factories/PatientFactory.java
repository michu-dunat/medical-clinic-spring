package com.company.factories;

import com.company.model.Patient;
import com.company.model.User;

import java.time.LocalDate;

public class PatientFactory extends UserFactory{
    public static Patient createDummyPatient(){
        return new Patient();
    }

    public static Patient createPatientForNewAccount(){
        return new Patient(true);
    }

    public static Patient createPatient(final String firstName, final String lastName, final LocalDate birthDate,
                                                 final String bloodType, final String address, final String city, final String postcode,
                                                 final String permanentAddress, final String permanentCity, final String permanentPostcode,
                                                 final String phoneNumber, final String contactPhone, final String emailAddress,
                                                 final User userId, final Boolean notificationStatus){
        return new Patient(firstName,lastName, birthDate, bloodType, address, city, postcode, permanentAddress,
                            permanentCity, permanentPostcode, phoneNumber, contactPhone, emailAddress, userId,
                            notificationStatus);
    }

    public static Patient createPatient(Patient dummy){
        return new Patient(dummy);
    }
}
