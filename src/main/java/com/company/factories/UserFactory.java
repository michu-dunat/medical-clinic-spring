package com.company.factories;

import com.company.model.Role;
import com.company.model.User;

public class UserFactory {
    public static User createDummyUser(){
        return new User();
    }
    public static User createUserWithNoPesel(User dummy){
        return new User(dummy.getUsername(), dummy.getPassword(), dummy.getRole());
    }

    public static User createUserWithPesel(User dummy){
        return new User(dummy.getUsername(), dummy.getPesel(), dummy.getPassword(), dummy.getRole());
    }

    public static User createUserWithNoPesel(final String username,final String password, final Role role){
        return new User(username, password, role);
    }

    public static User createUserWithPesel(final String username, final String pesel ,final String password, final Role role){
        return new User(username, pesel , password, role);
    }
}
