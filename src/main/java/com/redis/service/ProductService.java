package com.redis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.redis.entity.Product;

@Service
public interface ProductService {
   
	public Product save(Product product);
	
	public List<Product> findAll();
	
	public Product findproductById(int id);
	
	public String deleteProduct(int id);
}
