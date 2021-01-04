package com.company;

import com.company.model.Payment;
import com.company.services.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void findAllTest() {
        var payments = (List<Payment>) paymentService.findAll();
        System.out.println(payments.get(0).getPaymentMethod());
    }
}
