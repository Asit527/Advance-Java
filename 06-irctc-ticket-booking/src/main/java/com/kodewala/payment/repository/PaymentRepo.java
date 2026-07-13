package com.kodewala.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.payment.entity.PaymentEntity;

public interface PaymentRepo extends JpaRepository<PaymentEntity, Long> {

}
