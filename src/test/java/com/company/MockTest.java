package com.company;

import com.company.controllers.AppointmentController;
import com.company.controllers.HomeController;
import com.company.model.Appointment;
import com.company.model.Employee;
import com.company.model.Patient;
import com.company.repositories.AppointmentRepository;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.PatientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTest {

    @InjectMocks
    private AppointmentController appointmentController;

    @InjectMocks
    private HomeController homeController;

    private MockMvc mockMvc;
    private MockMvc mockMvc1;
    Patient patient;
    Appointment appointment;
    Employee employee;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Mock
    AppointmentRepository mockAppointmentRepository = mock(AppointmentRepository.class);

    @Before
    public void  setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        mockMvc1 = MockMvcBuilders.standaloneSetup(appointmentController).build();
        patient = patientRepository.findPatientById(1);
        employee = employeeRepository.findEmployeeById("D001");

    }

    @Test
    public  void getHome() throws Exception{
        mockMvc.perform(
                get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void saveAppointmentTest() throws Exception {
        Appointment a = new Appointment("1.39", LocalDate.of(2022,12,12), patient,employee);
        when(mockAppointmentRepository.save(any(Appointment.class))).thenReturn(a);
    }
    
}
