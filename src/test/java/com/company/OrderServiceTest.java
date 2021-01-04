package com.company;

import com.company.model.Order;
import com.company.model.Patient;
import com.company.model.User;
import com.company.services.OrderService;
import com.company.services.PatientService;
import com.company.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void findAllTest() {
        var orders = (List<Order>) orderService.findAll();
        System.out.println(orders.get(0));
    }
}
