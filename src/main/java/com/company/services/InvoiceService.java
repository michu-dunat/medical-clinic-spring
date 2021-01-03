package com.company.services;

import com.company.repositories.InvoiceRepository;
import com.company.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    public List<Invoice> findAll() {

        var invoices = (List<Invoice>) repository.findAll();

        return invoices;
    }
}
