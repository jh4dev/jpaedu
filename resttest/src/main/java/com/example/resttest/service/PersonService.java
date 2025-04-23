package com.example.resttest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.resttest.model.Person;
import com.example.resttest.repository.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}
	
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}
	
	public Optional<Person> getPerson(long id) {
		return personRepository.findById(id);
	}
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public void deletePerson(long id) {
		personRepository.deleteById(id);
	}
	
}
