package com.kodewala.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.orderservice.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
