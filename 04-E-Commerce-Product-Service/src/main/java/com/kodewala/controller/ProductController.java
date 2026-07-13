package com.kodewala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.request.ProductRequest;
import com.kodewala.response.ProductResponse;
import com.kodewala.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// CREATE
	@PostMapping
	public ProductResponse createProduct(@RequestBody ProductRequest request) {
		return productService.saveProduct(request);
	}

	// GET ALL
	@GetMapping
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}

	// GET BY ID
	@GetMapping("/{id}")
	public ProductResponse getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	// UPDATE
	@PutMapping("/{id}")
	public ProductResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
		return productService.updateProduct(id, request);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}