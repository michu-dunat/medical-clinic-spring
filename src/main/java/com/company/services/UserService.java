package com.company;

import Repositories.UserRepository;
import com.company.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {

        var users = (List<User>) repository.findAll();

        return users;
    }
}
