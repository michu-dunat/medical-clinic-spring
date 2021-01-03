package com.company;

import com.company.model.Invoice;
import com.company.model.Patient;
import com.company.services.InvoiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceServiceTest {

    @Autowired
    private InvoiceService invoiceService;

    @Test
    public void findAllTest() {
        var invoices = (List<Invoice>) invoiceService.findAll();
        System.out.println(invoices.get(0).getInvoice());
    }
}
