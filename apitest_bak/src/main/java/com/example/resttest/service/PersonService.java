package com.example.resttest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
	
	@Cacheable("persons")
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}
	
	public Optional<Person> getPerson(long id) {
		return personRepository.findById(id);
	}
	
	// 캐시무효화
	// CUD 트랜잭션 이후 READ 캐시를 초기화
	@CacheEvict(value = "persons", allEntries = true)
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	@CacheEvict(value = "persons", allEntries = true)
	public void deletePerson(long id) {
		personRepository.deleteById(id);
	}
	
}
