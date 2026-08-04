package com.kodewala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.request.ProductRequest;
import com.kodewala.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

		@Autowired
	private ProductService productService;
		
		@PostMapping("/createProduct")
		public String createProduct(@RequestBody ProductRequest productRequest ) {
			String productID =productService.createProduct(productRequest);
			return productID;
			
		}
	
}
