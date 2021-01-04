package com.company;

import com.company.model.Appointment;
import com.company.services.AppointmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;

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
}