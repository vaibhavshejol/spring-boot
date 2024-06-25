package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.entities.Users;
import com.jpa.test.repository.UserRepository;

@SpringBootApplication
public class SpringBootUsingJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringBootUsingJpaApplication.class, args);
		
		System.out.println("Application started successfully.....");
		
		UserRepository userRepository=context.getBean(UserRepository.class);
		
		Users user=new Users();
		user.setName("Vaibhav");
		user.setEmail("vaibhav@gmail.com");
		user.setContact("7418529633");
		
		Users user1=userRepository.save(user);
		
		System.out.println("Following user details saved successfully.....\n"+user1);
	}

}
