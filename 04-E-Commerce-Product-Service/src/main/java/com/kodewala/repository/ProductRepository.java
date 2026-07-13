package com.kodewala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodewala.entity.ProductEntity;

@Repository
public interface ProductRepository extends  JpaRepository<ProductEntity, Long> {

}
