package com.company;

import com.company.model.Appointment;
import com.company.model.Employee;
import com.company.model.Patient;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTest {

    @Mock
    Patient patient = mock(Patient.class);

    @Mock
    Employee doctor = mock(Employee.class);

    @Mock
    Appointment appointment = mock(Appointment.class);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
}
