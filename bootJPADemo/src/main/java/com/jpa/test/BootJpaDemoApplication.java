package com.jpa.test;

import java.util.List;
import java.util.Optional;

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
	     
//		User user=new User();
//	      
//	     user.setName("Marasini");
//	     user.setCity("Kirtipur");
//	     user.setStatus("Java developer");
//	     
//	    
//	     User user1=new User();
//	      
//	     user1.setName("TikiKumari");
//	     user1.setCity("Gulmi");
//	     user1.setStatus("vvvip mother");
//	     
//	     
//	     User user2=new User();
//	      
//	     user2.setName("Aastha Panthi");
//	     user2.setCity("Gulmi,Tamghas");
//	     user2.setStatus("Manager ");
//	     
//	     //save multiple users using Iterable
//	     List<User> users=List.of(user,user1,user2);
//	     Iterable<User> result=userRepo.saveAll(users);
//	     
//	     result.forEach(u ->{
//	    	 System.out.println(u);
//	     });
		
		//UPDATE THE USERS
//		
//		Optional<User> optional=userRepo.findById(2);
//		User user=optional.get();
//		
//		user.setName("Teknath Uppadhaya Buwa");
//		User result=userRepo.save(user);
//		System.out.println(result);
//		
		
		//GET ALL DATA 
//		
//		 Iterable<User> itr=userRepo.findAll();
//		 itr.forEach(user->System.out.println(user));
		
		//DELETE THE ELEMENT
		
//		userRepo.deleteById(54);
//		System.out.println("deleted");
		
		
		
		//IMPLEMENTATION OF CUSTOM FINDER METHOD
		List<User> users=userRepo.findByName("Marasini");
		
		users.forEach(e->System.out.println(e));
		
		List<User> nusers=userRepo.findByNameAndCity("TikiKumari", "Gulmi");
		nusers.forEach(e->System.out.println(e));
		
		 
		
	    

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
