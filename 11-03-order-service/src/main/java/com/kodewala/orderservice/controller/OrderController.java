package com.kodewala.orderservice.controller;

import com.kodewala.orderservice.entity.OrderEntity;
import com.kodewala.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders") // All URLs in this controller will start with /orders
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Endpoint to create an order: POST http://localhost:8081/orders
    @PostMapping
    public OrderEntity placeOrder(@RequestBody OrderEntity order) {
        return orderService.createOrder(order);
    }
}