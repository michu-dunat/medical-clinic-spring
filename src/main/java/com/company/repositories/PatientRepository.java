package com.company.repositories;

import com.company.model.Patient;
import com.company.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findPatientByUserId(User userId);
    List<Patient> findPatientsByFirstNameAndLastName(String firstName, String lastName);
    List<Patient> findPatientsByLastName(String lastName);
    Patient findPatientById(int id);

    @Modifying
    @Transactional
    @Query("update Patient p SET p.address = :address, p.city =:city, p.postcode = :postcode WHERE p.id = :id")
    void updateAddress(@Param("id") Integer id, @Param("address") String address, @Param("city") String city, @Param("postcode") String postcode);
}
