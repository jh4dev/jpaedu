package com.example.mission.service;

import org.springframework.stereotype.Service;

import com.example.mission.model.Obesity;
import com.example.mission.repository.ObesityRepository;

@Service
public class ObesityService {

	private final ObesityRepository obesityRepository;

	public ObesityService(ObesityRepository obesityRepository) {
		super();
		this.obesityRepository = obesityRepository;
	}
	
	public int addObesity(Obesity obesity) {
		
		int cnt = obesityRepository.insertProduct(obesity);
		
		return cnt;
	}
	
}
