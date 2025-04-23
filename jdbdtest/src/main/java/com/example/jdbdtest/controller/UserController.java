package com.example.jdbdtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.jdbdtest.my.MyClass;

@Controller
public class UserController {

	//의존성 주입 버전
	@Autowired
	private MyClass myClass;
	
	/*
	 * 생성자 사용 버전
	 * private final MyClass myClass;
	 * 
	 * public UserController(MyClass myClass) { this.myClass = myClass; }
	 */
	
	@GetMapping("/")
	public String index(Model model) {

//		MyClass myClass = new MyClass();
		String result = myClass.hello();

		System.out.println(result);
		
		return "index";
	}
}
