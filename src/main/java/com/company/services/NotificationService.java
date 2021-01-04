package com.company.services;

import com.company.model.Notification;
import com.company.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public List<Notification> findAll() {

        var notifications = (List<Notification>) repository.findAll();

        return notifications;
    }
}
