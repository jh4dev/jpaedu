package com.example.mission.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Obesity {

	private Double height;
	private Double weight;
	private Double obesity;
	
	public Obesity(Double heignt, Double weight) {
		
		this.height = heignt;
		this.weight = weight;
		this.obesity = weight / ((height - 100) * 0.85) * 100;
	}
}
