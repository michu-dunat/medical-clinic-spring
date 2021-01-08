package com.company.model;

import com.company.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class  MyUserDetails implements UserDetails {

    //*******THIS IS HARDCODED**********//
    private User user;

    public MyUserDetails(User user){
        this.user = user;
    }

    private String username;
    private String  password;
    private boolean isActive;
    private List<GrantedAuthority> authorities;

//    public MyUserDetails(User user){
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//        this.isActive = true;
//        this.authorities = Arrays.stream(user.getRole().getRole().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }

    public MyUserDetails(){
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.user.getRoleList().forEach(p->{
                    GrantedAuthority authority = new SimpleGrantedAuthority(p);
                    authorities.add(authority);
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "MyUserDetails{" +
                "user=" + user +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public User getUser() {
        return this.user;
    }
}