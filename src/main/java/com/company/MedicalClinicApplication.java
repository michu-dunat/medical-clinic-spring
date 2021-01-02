package com.company;

import com.company.Entities.User;
import Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MedicalClinicApplication{

	private static UserService userService;
	
		public static void main(String[] args) {
		SpringApplication.run(MedicalClinicApplication.class, args);
		System.out.println("Hello world");


		var users = (List<User>) userService.findAll();

		System.out.println(users.get(0));
	}

}
