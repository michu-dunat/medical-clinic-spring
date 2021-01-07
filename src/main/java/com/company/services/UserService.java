package com.company.services;

import com.company.repositories.UserRepository;
import com.company.model.User;
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

    public User findUserByPESEL(String PESEL){
        var user = repository.getUserByPesel(PESEL);
        return user.orElseThrow();
    }
}
