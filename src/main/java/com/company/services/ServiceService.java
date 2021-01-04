package com.company.services;

import com.company.model.Service;
import com.company.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository repository;

    public List<Service> findAll() {

        var services = (List<Service>) repository.findAll();

        return services;
    }
}
