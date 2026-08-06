package com.kodewala.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.orderservice.client.PaymentClient;
import com.kodewala.orderservice.entity.OrderEntity;
import com.kodewala.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentClient paymentClient;

    public OrderEntity createOrder(OrderEntity order) {
        // 1. Save the order to MySQL first with status "PENDING" (Gets ID = 1, etc.)
        order.setStatus("PENDING");
        OrderEntity savedOrder = orderRepository.save(order);

        try {
            // 2. Make synchronous call to Payment Service via OpenFeign
            String paymentResponse = paymentClient.processPayment(savedOrder);

            // 3. Check response from Payment Service
            if ("SUCCESS".equals(paymentResponse)) {
                savedOrder.setStatus("COMPLETED"); // Change status to COMPLETED
            } else {
                savedOrder.setStatus("FAILED");
            }

        } catch (Exception e) {
            // If Payment Service is down or throws an error, mark as FAILED
            savedOrder.setStatus("FAILED");
        }

        // 4. Update the existing row in MySQL and return it
        return orderRepository.save(savedOrder);
    }
}