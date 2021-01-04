package com.company.repositories;

import com.company.model.Patient;
import com.company.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findPatientByUserId(User userId);
    List<Patient> findPatientsByFirstNameAndLastName(String firstName, String lastName);

}
