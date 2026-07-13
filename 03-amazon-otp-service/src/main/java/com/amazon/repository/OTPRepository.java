package com.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.entity.Entity;

@Repository
public interface OTPRepository extends JpaRepository<Entity, Integer> {
	public Entity findByMobile(String Mobile);

}
