package com.company;

import com.company.model.Company;
import com.company.services.CompanyService;
import com.company.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Test
    public void findAllTest() {
        var companies = (List<Company>) companyService.findAll();
        System.out.println(companies.get(0).getCompanyName());
    }
}
