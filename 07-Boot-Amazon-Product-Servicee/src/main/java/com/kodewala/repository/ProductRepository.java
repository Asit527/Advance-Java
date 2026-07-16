package com.kodewala.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kodewala.entity.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity,Long> {

}
