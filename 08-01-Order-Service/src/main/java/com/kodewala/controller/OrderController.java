package com.kodewala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.dto.OrderRequest;
import com.kodewala.dto.OrderResponse;
import com.kodewala.service.OrderService;

@RestController
@RequestMapping("/kodewala/")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("order")
	public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
		
		return orderService.createOrder(orderRequest);
	}

}
