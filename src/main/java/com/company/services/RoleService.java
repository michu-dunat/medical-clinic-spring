package com.company.services;

import com.company.model.Role;
import com.company.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public List<Role> findAll() {

        var roles = repository.findAll();

        return roles;
    }

    public Role findbyId(int id){
        var x = repository.getRolesById(id);
        return x;
    }
}
