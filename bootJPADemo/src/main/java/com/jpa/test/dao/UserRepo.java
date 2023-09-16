package com.jpa.test.dao;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;


public interface UserRepo  extends CrudRepository<User, Integer> {
	
	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name, String city);
	
	
	//FOR JPQL QUERIES
	@Query("select u from User u")
	public List<User> getAllUser();
	
	@Query("select u from User u WHERE u.name=:n")
	public List<User> getUserByName(@Param("n") String name);
	
	
	//FOR NATIVE QUERIES
	@Query(value = "select * from User", nativeQuery = true)
	public List<User> getusers();
		
	

}
