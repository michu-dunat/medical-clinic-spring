package com.company;

import com.company.model.MyUserDetails;
import com.company.model.Patient;
import com.company.model.User;
import com.company.repositories.PatientRepository;
import com.company.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository repo;

    @Autowired
    private PatientRepository patientRepository;

    public MyUserDetailsService(UserRepository repository){
        this.repo = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<User> user = repo.findByUsername(username);
            User usr = user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return new MyUserDetails(usr);
    }

    public Patient getPatientByUser(MyUserDetails myUserDetails) {
        Patient patient = patientRepository.findPatientByUserId(myUserDetails.getUser());
        return patient;
    }
}