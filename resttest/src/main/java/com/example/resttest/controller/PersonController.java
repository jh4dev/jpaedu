package com.example.resttest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.resttest.model.Person;
import com.example.resttest.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}


	@GetMapping
	public List<Person> getAllPeople() {
		return personService.getAllPerson();
	}
	
	@GetMapping("/{id}")
	public Optional<Person> getPerson(@PathVariable long id) {
		return personService.getPerson(id);
	}
	
	@PostMapping
	public Person registPerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
		person.setId(id);
		return personService.savePerson(person);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String deletePerson(@PathVariable long id) {
		personService.deletePerson(id);
		return "삭제됨";
	}
	
}
