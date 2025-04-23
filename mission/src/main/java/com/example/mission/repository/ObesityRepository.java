package com.example.mission.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mission.model.Obesity;

@Repository
public class ObesityRepository {

private final JdbcTemplate jdbcTemplate;
	
	public ObesityRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insertProduct(Obesity obesity) {
		
		String sql = "insert into obesity(height, weight, obesity) values(?, ?, ?)";
		
		int count = jdbcTemplate.update(sql, obesity.getHeight(), obesity.getWeight(), obesity.getObesity()); 
		return count;
	}
	
}
