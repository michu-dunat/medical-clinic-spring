package com.company.services;

import com.company.repositories.EmployeeRepository;
import com.company.model.Employee;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.Configuration;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> findAll() {

        var employees = (List<Employee>) repository.findAll();

        return employees;
    }

    public List<Employee> findAllDoctors() {
        return null;
    }
}
