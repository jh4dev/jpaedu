package com.example.resttest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.resttest.model.Person;
import com.example.resttest.service.PersonService;

@RestController
@RequestMapping("api/persons")
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}

	@GetMapping("/{id}")
	public Optional<Person> getPersonById( @PathVariable Long id){
		return personService.getPersonById(id);
	}


	@PostMapping
	public Person insertPerson( @RequestBody Person person)
	{
		return personService.savePerson( person );
	}

	@PutMapping("/{id}")
	public Person updatePerson( @PathVariable Long id, @RequestBody Person person)
	{
		person.setId(id);
		return personService.savePerson( person );
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public String deletePerson( @PathVariable Long id)
	{
		personService.deletePerson(id);
		return "<h3>삭제됨</h3>";
	}

//	@PostMapping
//	public Person insertPerson( @RequestParam String name , @RequestParam int age)
//	{
//		return personService.savePerson( new Person(null, name, age) );
//	}

}



