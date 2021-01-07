package com.company;

import com.company.model.Payment;
import com.company.model.Role;
import com.company.services.PaymentService;
import com.company.services.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void findAllTest() {
        var payments = (List<Role>) roleService.findAll();
        System.out.println(payments.get(0));
    }

    @Test
    public void findByIdTest(){
        var role = roleService.findbyId(2);
        System.out.println(role.getRole());
    }
}