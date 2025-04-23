package com.example.resttest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.resttest.model.Order;
import com.example.resttest.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orederRepository) {
		super();
		this.orderRepository = orederRepository;
	}
	
	public List<Order> getAllOrders(){
		
		return orderRepository.findAll();
	}
	
	public Order insertOrder(Order order) {
		
		return orderRepository.save(order);
	}
}
