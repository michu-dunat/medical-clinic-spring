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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTest {

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
    @InjectMocks
    private AppointmentController appointmentController;
    @InjectMocks
    private HomeController homeController;
    private MockMvc mockMvc;
    private MockMvc mockMvc1;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        //mockMvc1 = MockMvcBuilders.standaloneSetup(appointmentController).and().webAppContextSetup(context).build();
        patient = patientRepository.findPatientById(1);
        employee = employeeRepository.findEmployeeById("D001");
        mockMvc1 = MockMvcBuilders.webAppContextSetup(context).apply(SecurityMockMvcConfigurers.springSecurity()).build();


    }

    @Test
    public void getHome() throws Exception {
        mockMvc.perform(
                get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void saveAppointmentTest() throws Exception {
        Appointment a = new Appointment("1.39", LocalDate.of(2022, 12, 12), patient, employee);
        when(mockAppointmentRepository.save(any(Appointment.class))).thenReturn(a);
    }

    @Test
    public void getClinicWorkerHomePage() throws Exception {
        UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken("PawMac", "haslo");
        Authentication authenticatedUser = authenticationManager.authenticate(loginToken);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

        mockMvc1.perform(
                get("/clinic-worker").secure(true))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

}
