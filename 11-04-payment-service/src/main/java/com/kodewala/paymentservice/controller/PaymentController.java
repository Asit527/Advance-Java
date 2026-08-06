package com.kodewala.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "notification-topic"; // Your notification topic

    @PostMapping
    public String processPayment(@RequestBody Map<String, Object> paymentRequest) {
        try {
            String itemName = (String) paymentRequest.get("itemName");
            Object price = paymentRequest.get("price");

            // TODO: Add your payment gateway logic here if needed

            // 1. Send message to Kafka for the Notification Service to consume
            String kafkaMessage = "Payment successful for order item: " + itemName + " amounting to " + price;
            kafkaTemplate.send(TOPIC, kafkaMessage);

            // 2. Return SUCCESS string back to Order Service via OpenFeign
            return "SUCCESS";

        } catch (Exception e) {
            return "FAILED";
        }
    }
}