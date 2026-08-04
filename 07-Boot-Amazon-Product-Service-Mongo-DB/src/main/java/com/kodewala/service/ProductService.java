package com.kodewala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.entity.ProductEntity;
import com.kodewala.repository.ProductRepository;
import com.kodewala.request.ProductRequest;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public String createProduct(ProductRequest productRequest) {
		ProductEntity productEntity = new ProductEntity();
		
		productEntity.setName(productRequest.getName());
		productEntity.setPrice(productRequest.getPrice());
		productEntity.setQuantity(productRequest.getQuantity());
		ProductEntity productEntity2 = productRepository.save(productEntity);
		
		
		return  productEntity2.getId();
	}
	
}
