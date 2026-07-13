package com.kodewala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.entity.ProductEntity;
import com.kodewala.repository.ProductRepository;
import com.kodewala.request.ProductRequest;
import com.kodewala.response.ProductResponse;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // CREATE
    public ProductResponse saveProduct(ProductRequest request) {

        ProductEntity entity = new ProductEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setPrice(request.getPrice());
        entity.setQuantity(request.getQuantity());
        entity.setCategory(request.getCategory());

        ProductEntity saved = productRepository.save(entity);

        return mapToResponse(saved);
    }

    // READ ALL
    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // READ BY ID
    public ProductResponse getProductById(Long id) {

        ProductEntity entity = productRepository.findById(id).orElse(null);

        if (entity == null) {
            return null;
        }

        return mapToResponse(entity);
    }

    // UPDATE
    public ProductResponse updateProduct(Long id, ProductRequest request) {

        ProductEntity existing = productRepository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setQuantity(request.getQuantity());
        existing.setCategory(request.getCategory());

        ProductEntity updated = productRepository.save(existing);

        return mapToResponse(updated);
    }

    // DELETE
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // MAPPER
    private ProductResponse mapToResponse(ProductEntity entity) {

        ProductResponse response = new ProductResponse();

        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setPrice(entity.getPrice());
        response.setQuantity(entity.getQuantity());
        response.setCategory(entity.getCategory());

        return response;
    }
}