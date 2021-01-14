package com.company;

import com.company.handlers.AppointmentHandler;
import com.company.model.Patient;
import com.company.model.Role;
import com.company.model.User;
import com.company.repositories.RoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientTests {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AppointmentHandler ah;
    Patient patient;
    Patient patient2;
    Role role;
    User user;


    @Before
    public void init(){
        patient = ah.getPatient("1");
        patient2 = ah.getPatient("124657");
        role = roleRepository.getRolesById(2);
        user = patient.getUserId();
    }

    @Test
    public void testGetPatient(){
        assertNotNull(patient);
        assertNull(patient2);
    }

    @Test
    public void testCheckPatientRole(){
        assertEquals(role.getRole(), user.getRole().getRole());
    }

}
