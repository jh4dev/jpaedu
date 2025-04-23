package com.example.jdbdtest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jdbdtest.model.Product;
import com.example.jdbdtest.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/index")
	@ResponseBody
	public String pdocut(Model model) {
		
		return "product call";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		
		return "form";
	}
	
	@GetMapping("/insert")
	@ResponseBody
	public String addProduct(Model model, @RequestParam String name, @RequestParam Double price)  {
		int cnt = 0;
		cnt = productService.addProduct(name, price);
		
		String result = cnt > 0 ? "SUCCESS" : "FAIL";
		
		model.addAttribute("result", result + " : " + cnt);
		
		return result;
	}
	
	@GetMapping("/list")
	public String getAllProducts(Model model) {
		List<Product> list = productService.getAllProducts();
		model.addAttribute("products", list);
		
		return "list";
	}
}
