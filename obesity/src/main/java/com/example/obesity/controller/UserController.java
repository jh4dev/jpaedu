package com.example.obesity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.obesity.calc.ObesityCalc;

@Controller
public class UserController {

	@GetMapping
	public String index(Model model) {
		
		return "index";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		
		return "form";
	}
	
	@GetMapping("/biman")
	public String biman(Model model, @RequestParam Double height, @RequestParam Double weight) {
		
//		double stdWeight = (height - 100) * 0.85;
//		double obesity = (weight/stdWeight) * 100;
//		
//		String result = "";
//		String imgSrc = "/images/";
//		
//		if(obesity <= 90) {
//			result = "저체중";
//			imgSrc += "under.png";
//		}
//		else if (obesity <= 110) {
//			result = "정상";
//			imgSrc += "normal.png";
//		}
//		else if (obesity <= 120) {
//			result = "과체중";
//			imgSrc += "over.png";
//		}
//		else {
//			result = "비만";
//			imgSrc += "obese.png";
//		}
		
		ObesityCalc oCalc = new ObesityCalc();
		oCalc.calcObesity(height, weight);
		
		model.addAttribute("result", oCalc.getResult());
		model.addAttribute("imgSrc", oCalc.getImgSrc());
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		
		
		return "bimanview";
	}
	
	@GetMapping("/formtest")
	public String formtest(Model model) {
		
		return "formtest";
	}
}
