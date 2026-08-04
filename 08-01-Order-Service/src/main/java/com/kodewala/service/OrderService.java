package com.kodewala.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodewala.dto.OrderRequest;
import com.kodewala.dto.OrderResponse;
import com.kodewala.entity.OrderEntity;
import com.kodewala.kafka.producer.service.KafkaService;
import com.kodewala.payment.entity.PaymentEntity;
import com.kodewala.payment.repository.PaymentRepo;
import com.kodewala.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	PaymentRepo paymentRepo;
	@Autowired
	KafkaService kafkaService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	 public OrderResponse createOrder(OrderRequest orderRequest) {

	        // Save Order
	        OrderEntity orderEntity = new OrderEntity();

	        orderEntity.setCustomerName(orderRequest.getCustomerName());
	        orderEntity.setProductName(orderRequest.getProductName());
	        orderEntity.setQuantity(orderRequest.getQuantity());
	        orderEntity.setOrderDate(LocalDateTime.now());

	        OrderEntity savedOrder = orderRepository.save(orderEntity);

	        // Create Payment
	        PaymentEntity paymentEntity = new PaymentEntity();

	        paymentEntity.setOrderId(savedOrder.getOrderId());
	        paymentEntity.setAmount(100.0);
	        paymentEntity.setPaymentStatus("SUCCESS");
	        paymentEntity.setPaymentDate(LocalDateTime.now());

	        PaymentEntity savedPayment = paymentRepo.save(paymentEntity);

	        // Prepare Response
	        OrderResponse response = new OrderResponse();

	        response.setOrderId(savedOrder.getOrderId());
	        response.setCustomerName(savedOrder.getCustomerName());
	        response.setProductName(savedOrder.getProductName());
	        response.setQuantity(savedOrder.getQuantity());
	        response.setOrderDate(savedOrder.getOrderDate());

	        // Publish Kafka Event as JSON
	        try {
	            String jsonMessage = objectMapper.writeValueAsString(response);
	            kafkaService.publishMessage("order-confirmed", jsonMessage);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return response;
	    }
}