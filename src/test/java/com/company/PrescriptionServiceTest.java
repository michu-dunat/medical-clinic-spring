package com.company;

import com.company.model.Prescription;
import com.company.services.PrescriptionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrescriptionServiceTest {

    @Autowired
    private PrescriptionService prescriptionService;

    @Test
    public void findAllTest() {
        var prescriptions = (List<Prescription>) prescriptionService.findAll();
        System.out.println(prescriptions.get(0));
    }
}
