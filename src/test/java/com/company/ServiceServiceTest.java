package com.company;

import com.company.model.Service;
import com.company.services.ServiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceServiceTest {

    @Autowired
    private ServiceService serviceService;

    @Test
    public void findAllTest() {
        var services = (List<Service>) serviceService.findAll();
        System.out.println(services.get(0).getPrice());
    }
}

