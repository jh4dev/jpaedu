package com.example.resttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resttest.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
