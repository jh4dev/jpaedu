package com.example.jdbdtest.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.jdbdtest.model.Product;

@Repository
public class ProductRepository {

	private final JdbcTemplate jdbcTemplate;
	
	public ProductRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insertProduct(String name, Double price) {
		
		String sql = "insert into product(name, price) values(?, ?)";
		
		int count = jdbcTemplate.update(sql, name, price); 
		return count;
	}
	
	public List<Product> getAllProducts() {
		
		String sql = "select * from product";
		
		RowMapper<Product> rowMapper = (rs, rowNum) -> new Product(rs.getString("name"), rs.getDouble("price"));
		
		List<Product> list = jdbcTemplate.query(sql, rowMapper);
		
		return list;
	}
	
}
