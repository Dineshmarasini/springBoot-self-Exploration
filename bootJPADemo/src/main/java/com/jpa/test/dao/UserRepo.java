package com.jpa.test.dao;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entities.User;


public interface UserRepo  extends CrudRepository<User, Integer> {
	
	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name, String city);
		
	

}
