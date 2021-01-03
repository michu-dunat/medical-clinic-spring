package com.company;

import com.company.model.MedicalRecord;
import com.company.services.MedicalRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicalRecordServiceTest {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @Test
    public void findAllTest() {
        var invoices = (List<MedicalRecord>) medicalRecordService.findAll();
        System.out.println(invoices.get(0));
    }
}
