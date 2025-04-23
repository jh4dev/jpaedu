package com.example.jpatest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpatest.model.Person;
import com.example.jpatest.service.PersonService;

@Controller
public class UserController {

	private final PersonService personService;
	
	public UserController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@GetMapping
	public String index(Model model) {
		
		return "index";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		
		return "form";
	}
	
	@GetMapping("/insert")
	public String insert(Model model, @RequestParam String name, @RequestParam int age) {
		long saveCnt;
		saveCnt = personService.insertPerson(name, age);
		
		model.addAttribute("result", saveCnt + " 행 추가 완료");
		
		return "insertview";
	}
	
	@GetMapping("/select")
	public String select(Model model) {
		
		model.addAttribute("people", personService.selectAll());
		
		return "selectview";
	}
	
	@GetMapping("/selectname")
	public String selectName(Model model) {
		Person person = personService.selectByName("김길동");
		model.addAttribute("person", person);
		
		return "findnameview";
	}
	
	@GetMapping("/selectjpql")
	public String selectJpql(Model model) {
		
		model.addAttribute("people", personService.selectByNameOrAgeJPQL(20, "홍길동"));
		
		return "selectview";
	}
	
	@GetMapping("/delete")
	public String deletePerson(Model model) {
		model.addAttribute("result", personService.deletePerson(1));
		
		return "insertview";
	}
	
	@GetMapping("/update")
	public String updatePerson(Model model) {
		model.addAttribute("result", personService.updatePerson("김길동", "은하철도", 999));
		
		return "insertview";
	}
}
