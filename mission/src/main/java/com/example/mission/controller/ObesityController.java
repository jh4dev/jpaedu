package com.example.mission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mission.model.Obesity;
import com.example.mission.service.ObesityService;

@Controller
@RequestMapping("/obesity")
public class ObesityController {

	private final ObesityService obesityService;

	public ObesityController(ObesityService obesityService) {
		super();
		this.obesityService = obesityService;
	}
	
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}
	
	@GetMapping("/insert")
	public String addProduct(Model model, @RequestParam Double height, @RequestParam Double weight)  {
		int cnt = 0;
		
		Obesity obesity = new Obesity(height, weight);
		
		cnt = obesityService.addObesity(obesity);
		
		String result = cnt > 0 ? "SUCCESS" : "FAIL";

		model.addAttribute("result", result + " : " + cnt);
		model.addAttribute("obesity", obesity);
		
		return "result";
	}
}
