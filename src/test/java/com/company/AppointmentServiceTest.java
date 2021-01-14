package com.company;

import com.company.handlers.AppointmentHandler;
import com.company.model.Appointment;
import com.company.model.Employee;
import com.company.model.Patient;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.PatientRepository;
import com.company.services.AppointmentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceTest {

    @Autowired
    private AppointmentHandler appointmentHandler;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PatientRepository patientRepository;

    Employee emp1;
    Employee emp2;
    LocalDate date;
    List<Patient> patientList;
    @Before
    public void init(){
        date = LocalDate.of(2021,2,20);
        emp1 = employeeRepository.findEmployeeById("D001");
        emp2 = employeeRepository.findEmployeeById("D002");
        patientList = patientRepository.findPatientsByLastName("Maciończyk");
    }

    @Test
    public void findAllTest() {
        var appointments = (List<Appointment>) appointmentService.findAll();
        System.out.println(appointments.get(0));
    }

    @Test
    public void findByEmployeeId() {
        var appointments = appointmentService.findAppointmentByEmployee();
        for (Appointment appointment:
             appointments) {
            System.out.println(appointment.toString());
        }
    }

    @Test
    public void isAbleToCreateAppointmentOnDateTest(){
        assertFalse(appointmentHandler.isAbleToCreateAppointmentOnDate(date, emp1));
        assertTrue(appointmentHandler.isAbleToCreateAppointmentOnDate(date, emp2));
    }

    @Test
    public void findListOfPatients(){
        assertFalse(patientList.isEmpty());
    }



}