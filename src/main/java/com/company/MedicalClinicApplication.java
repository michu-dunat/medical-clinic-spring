package com.company;

import com.company.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MedicalClinicApplication{
		public static void main(String[] args) {
		SpringApplication.run(MedicalClinicApplication.class, args);
		System.out.println("Hello World");
	}

}
