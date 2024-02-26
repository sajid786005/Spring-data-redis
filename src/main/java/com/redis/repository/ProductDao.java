package com.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.entity.Product;

@Repository
public class ProductDao  {
	
	public static final String HASH_KEY = "Product";
	
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id){
    	System.out.println("collect data from database");
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteProduct(int id){
    	System.out.println("deleted");
         template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }
}
	


