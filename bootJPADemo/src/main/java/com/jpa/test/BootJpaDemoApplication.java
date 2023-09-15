package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepo;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootJpaDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(BootJpaDemoApplication.class, args);
		UserRepo userRepo=context.getBean(UserRepo.class);
	     User user=new User();
	     user.setId(2);
	     user.setName("Teknath");
	     user.setCity("Gulmi");
	     user.setStatus("vvvip");
	     
	     User user1=userRepo.save(user);
	     System.out.println(user1);
	     
	    
	}

}
