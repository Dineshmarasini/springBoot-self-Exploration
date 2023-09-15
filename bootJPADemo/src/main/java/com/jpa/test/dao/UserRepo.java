package com.jpa.test.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entities.User;


public interface UserRepo  extends CrudRepository<User, Integer> {

}
