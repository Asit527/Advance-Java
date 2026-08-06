package com.kodewala.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "11-04-payment-service") // Must match spring.application.name in Payment Service
public interface PaymentClient {

    @PostMapping("/payments")
    String processPayment(@RequestBody Object paymentRequest);
}