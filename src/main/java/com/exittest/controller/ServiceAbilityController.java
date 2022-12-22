package com.exittest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exittest.model.Product;
import com.exittest.model.ServiceAbility;
import com.exittest.repository.ServiceAbilityRepo;

@RestController
public class ServiceAbilityController {
	
	@Autowired
	ServiceAbilityRepo serviceAbilityRepo;

	@GetMapping("/serviceability/{pincode}")
	@CrossOrigin
	public List<ServiceAbility> price(@PathVariable("pincode") String pincode){
		
		List<ServiceAbility> list=new ArrayList<ServiceAbility>();
		 list=serviceAbilityRepo.findByPincode(pincode);
		 for(ServiceAbility p:list)
			  System.out.println(p);
		return list;
	}

}
