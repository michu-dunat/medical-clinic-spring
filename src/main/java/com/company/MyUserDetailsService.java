package com.company;

import com.company.model.MyUserDetails;
import com.company.model.User;
import com.company.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    public MyUserDetailsService(UserRepository repository) {
        this.repo = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repo.findByUsername(username);
        User usr = user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return new MyUserDetails(usr);
    }

}