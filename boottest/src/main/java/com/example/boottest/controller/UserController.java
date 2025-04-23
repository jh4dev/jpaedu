package com.example.boottest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.boottest.model.Movie;

@Controller
public class UserController {

	@GetMapping("/")
	public String index(Model model) {
		
		return "index";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		
		return "test";
	}
	
	@GetMapping("/leaf")
	public String leaf(Model model) {
		
		model.addAttribute("hello", "Nice to meet you");
		model.addAttribute("user", "Ahn");

		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie(1L, "https://img.megabox.co.kr/SharedImg/2021/02/01/qDLdOQKdvIeLyniUM7DX567IaJeyJmbv_420.jpg","무한열차편", "2021.01.27", "하나에 나츠키", "소토자키 하루오"));
		movies.add(new Movie(2L, "https://img.megabox.co.kr/SharedImg/2021/06/10/7deO12OmPdV0fCZlT1YA68dpI6mOGDKI_420.jpg","캐시트럭", "2021.06.09", "제이슨 스타뎀", "가이 리치"));
		movies.add(new Movie(3L, "https://img.megabox.co.kr/SharedImg/2021/05/21/L1u1sOkUsSQ0Ut8erY62YQxGtOMcInj2_420.jpg","500일의 썸머", "2021.05.26", "클로이 모레츠", "마크 웹"));
		model.addAttribute("movies",  movies);   
		
		return "leaf";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		
		return "form";
	}
	
	@GetMapping("/person")
	public String person(
			@RequestParam("name") String name, 
			@RequestParam("age") int age, 
			@RequestParam("birth") String birth, 
			Model model) {

		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("birth", birth);
		
		return "person";
	}
}
