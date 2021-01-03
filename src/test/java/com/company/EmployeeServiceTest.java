package com.company;

import com.company.model.Employee;
import com.company.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void findAllTest() {
        var employees = (List<Employee>) employeeService.findAll();
        System.out.println(employees.get(0).getBirthDate());
    }
}

