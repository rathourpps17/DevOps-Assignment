package com.exittest.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exittest.model.Product;
import com.exittest.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	public ProductRepo productRepo;
	
	public void store(MultipartFile file) throws IOException {	
		
		Product product=new Product(11,"n3","b4","c11",1100,"d11",file.getBytes());
		productRepo.save(product);	
		}
	
	
	
} 
