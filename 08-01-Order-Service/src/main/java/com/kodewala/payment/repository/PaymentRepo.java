package com.kodewala.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodewala.payment.entity.PaymentEntity;

@Repository
public interface PaymentRepo  extends JpaRepository<PaymentEntity, Long>{

}
