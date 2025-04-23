package com.example.resttest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}
	
	@GetMapping("/update")
	public String update() {
		return "update";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "delete";
	}
	
	@GetMapping("/personview")
	public String personview(Model model) {
		return "personview";
	}
}
