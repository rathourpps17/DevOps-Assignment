package com.exittest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exittest.model.Price;
import com.exittest.model.Product;

import com.exittest.repository.ProductRepo;
import com.exittest.service.ProductService;

import net.bytebuddy.implementation.HashCodeMethod;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	ProductService productService;
	
	@PostMapping(path ="/search", consumes= { "application/json" })
	@CrossOrigin
	public List<Product> search(@RequestBody Product product){
		List<Product> list =new ArrayList<Product>();
		Set<Product> set=new HashSet<Product>();
		
			  if(product.getCode()!=null){ 
				 set.addAll(productRepo.findByCode(product.getCode()));	
			  }
              if(product.getBrand()!=null){
            	  System.out.println(product.getBrand());
            	  set.addAll( productRepo.findByBrand(product.getBrand()));
 				
			  }
              if(product.getName()!=null){
            	  set.addAll(productRepo.findByName(product.getName()));
			  }

            list.addAll(set);
              for(Product p:list)
            	  System.out.println("result  "+p );
			return list;
	}
	
	@PostMapping(path ="/price", consumes= { "application/json" })
	@CrossOrigin
	public List<Product> price(@RequestBody Price price){
		
		List<Product> list=new ArrayList<Product>();
		 list=productRepo.findPrice(price.getRange1(),price.getRange2());
		return list;
	}
	
	@GetMapping("/details/{productcode}")
	@CrossOrigin
	public List<Product> price(@PathVariable("productcode") String productcode){
		
		List<Product> list=new ArrayList<Product>();
		 list=productRepo.findByCode(productcode);
		 for(Product p:list)
			 System.out.println(p);
		return list;
	}

	@PostMapping(path="/fileupload")
	public void upload(@RequestParam("File") MultipartFile file) throws IOException {
        productService.store(file);
    }
}
