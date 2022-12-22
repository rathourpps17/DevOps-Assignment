package com.exittest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exittest.model.User;
import com.exittest.repository.UserRepo;


@RestController
public class LoginController {

	@Autowired
	UserRepo userRepo;
	
	@PostMapping(path ="/login", consumes = { "application/json" })
	@CrossOrigin
	public boolean login(@RequestBody User user){	
		List<User> list=userRepo.findByEmail(user.getEmail());
	      if(list.size()==0)
	    	  return false;
	    User user1=list.get(0);
	    if(user1.getPassword().equals(user.getPassword())) 
	    	return true;
	    	
	   return false;	  
	}
	
}
