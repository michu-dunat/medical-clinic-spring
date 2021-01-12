package com.company.handlers;

import com.company.model.DataReader;
import com.company.model.Patient;
import com.company.model.Role;
import com.company.model.User;
import com.company.repositories.PatientRepository;
import com.company.repositories.RoleRepository;
import com.company.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AddAccountHandler {

    User user;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    RoleRepository roleRepository;

    public String validate(String PESEL){
        return PESEL;
    }

    public boolean checkIfUserExistsWithGivenPESEL(String PESEL) {
        var usr = userRepository.getUserByPesel(PESEL);
        Role usrRole = usr.orElseGet(User::new).getRole();
        return usrRole != null;
    }

    public boolean createAccount(Patient p, User u) throws Exception{
        try {
            u.setRole(roleRepository.getRolesById(2));
            u.setUsername(p.getFirstName().substring(0, 3) + p.getLastName().substring(0, 3) + u.getPesel());
            u.setPassword("" + p.getFirstName().charAt(0) + p.getLastName().charAt(0) + u.getPesel());
            userRepository.save(u);
            p.setUserId(u);
            patientRepository.save(p);
        }catch (Exception e){
            userRepository.delete(u);
            patientRepository.delete(p);
            return false;
       }
        return true;
    }

}
