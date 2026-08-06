package com.kodewala.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "payment-success-topic";

    @PostMapping
    public String processPayment(@RequestBody Map<String, Object> orderData) {
        // 1. Handle payment logic
        System.out.println("Payment processed successfully for order: " + orderData);

        // 2. Publish a message to Kafka for the Notification Service
        String message = "Payment successful for order item: " + orderData.get("itemName");
        kafkaTemplate.send(TOPIC, message);

        // 3. Return SUCCESS so Order Service completes the order
        return "SUCCESS";
    }
}