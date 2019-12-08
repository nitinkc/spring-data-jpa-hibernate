package com.learningJPA.bHardCodedData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserDAOService service;

	//Retrieve all users
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}

	//Retrieve specific users
	@GetMapping(path = "/user/{id}")
	public User retrieveUserById(@PathVariable int id){
		return service.findById(id);
	}
}