package com.company.services;

import com.company.model.Order;
import com.company.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {

        var orders = (List<Order>) repository.findAll();

        return orders;
    }
}
