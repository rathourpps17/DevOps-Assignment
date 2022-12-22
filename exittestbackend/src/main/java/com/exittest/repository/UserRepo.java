package com.exittest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exittest.model.Product;
import com.exittest.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	  List<User> findByEmail(String email);
	  
	  @Query(value="select * from User",nativeQuery = true)
		 List<User> findAl();
		 
}

