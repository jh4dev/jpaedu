package com.example.resttest.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.BatchSize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private long id;
	
	private String name;
	
	private int age;
	
	
	//BatchSize => N + 1 문제를 줄이기 위해, 일괄 조회 시 한 번에 10개까지 가져오도록 설정
	/*
	 * What is N + 1 Problem?
	 * 1: N 구조에서 1 에 대한 데이터 조회 시, 개선 로직이 없다면 N + 1 회 쿼리가 수행됨
	 * */
	@OneToMany(mappedBy="person", fetch=FetchType.LAZY)
	@BatchSize(size = 10)
	private List<Order> orders = new ArrayList<>();
}
