package com.exittest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exittest.model.Product;


public interface ProductRepo extends JpaRepository<Product, Integer> {
	 //List<User> findByEmail(String email);
	 List<Product> findByName(String name);
	 List<Product> findByBrand(String brand);
	 List<Product> findByCode(String code);
	 
	
	 

	 
	 @Query(value="select * from Product where price>=:range1 and price<=:range2",nativeQuery = true)
	 List<Product> findPrice(@Param(value = "range1") float range1,@Param(value = "range2") float range2);
}
