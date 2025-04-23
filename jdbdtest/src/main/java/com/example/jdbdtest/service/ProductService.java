package com.example.jdbdtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jdbdtest.model.Product;
import com.example.jdbdtest.repository.ProductRepository;

@Service
public class ProductService {


	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	public int addProduct(String name, Double price) {
		int count = productRepository.insertProduct(name, price);
		
		return count;
	}
	

	public List<Product> getAllProducts() {
		List<Product> list = productRepository.getAllProducts();
		
		return list;
	}
}
