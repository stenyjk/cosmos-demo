package com.example.cosmos.cosmosdemo.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cosmos.cosmosdemo.model.User;
import com.example.cosmos.cosmosdemo.repo.UserRepository;

@RestController
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	private UserRepository repo;
	
	@PostMapping("/users/add")
	public String addUser(User inputUser) {
		
		LOGGER.info("addUser :: START inputUser details :: {}",inputUser);
		User user = new User();
		
		
		user.setId(UUID.randomUUID().toString());
		user.setAddress(inputUser.getAddress());
		user.setFirstName(inputUser.getFirstName());
		user.setLastName(inputUser.getLastName());
		user.setPhone(inputUser.getPhone());
		LOGGER.info("addUser :: START User details :: {}",user);
		User savedUser = repo.save(user);
		LOGGER.info("addUser :: END, saved user id :: {}",savedUser.getId());
		return savedUser.getId();
		

	}

	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable("id") String id) {
		
		LOGGER.info("retriveUser :: START id :: {}",id);
		return repo.findById(id).get();

	}

	@GetMapping(value = "/users")
	public List<User> retriveAll() {
		
		LOGGER.info("retriveAllUsers :: START ");
		List<User>users = (List<User>) repo.findAll();
		LOGGER.info("All users retrived :: ",users);
		return users;

	}

}
