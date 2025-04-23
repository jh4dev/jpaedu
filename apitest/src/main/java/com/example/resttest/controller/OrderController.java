package com.example.resttest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resttest.model.Order;
import com.example.resttest.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@GetMapping
	public List<Order> getAllOrder() {
	
		return orderService.getAllOrders();
	}
	
	@PostMapping
	public Order insertOrder(@RequestBody Order order) {
		
		log.info(order.toString());
		return orderService.insertOrder(order);
	}
}
