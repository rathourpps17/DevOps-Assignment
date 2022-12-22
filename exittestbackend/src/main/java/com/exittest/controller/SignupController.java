package com.exittest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exittest.model.User;
import com.exittest.repository.UserRepo;


@RestController
public class SignupController {
	
	@Autowired
	UserRepo userRepo;
	
	@PostMapping(path ="/signup", consumes = { "application/json" })
	@CrossOrigin
	public Boolean signup(@RequestBody User user) {	
		List<User> list=userRepo.findAl();
		for(User u:list) {
			if(u.getEmail().equals(user.getEmail()))
				return false;
		}			
		userRepo.save(user);
		return true;
	}

}
