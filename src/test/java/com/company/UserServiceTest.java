package com.company;

import com.company.model.User;
import com.company.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAllTest() {
        var users = (List<User>) userService.findAll();
        System.out.println(users.get(0));
    }

    @Test
    public void findAllByPESEL(){
        var user = userService.findUserByPESEL("00290112345");
        System.out.println(user.toString());
    }
}
