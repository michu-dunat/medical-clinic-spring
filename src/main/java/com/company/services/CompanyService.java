package com.company.services;

import com.company.repositories.CompanyRepository;
import com.company.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public List<Company> findAll() {

        var companies = (List<Company>) repository.findAll();

        return companies;
    }
}
