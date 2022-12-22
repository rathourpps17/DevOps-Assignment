package com.exittest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.exittest.model.ServiceAbility;

public interface ServiceAbilityRepo extends JpaRepository<ServiceAbility, Integer>{
	List<ServiceAbility> findByPincode(String pincode);

}
