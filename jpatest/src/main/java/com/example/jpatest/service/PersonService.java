package com.example.jpatest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jpatest.model.Person;
import com.example.jpatest.repository.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}
	
	public long personCount() {

		long pCnt = personRepository.count();
		return pCnt;
	}
	
	public long insertPerson(String name, int age) {
		
		long before = personRepository.count();
		personRepository.save(new Person(null, name, age));
		long after = personRepository.count();
		return after - before;
	}
	
	public String deletePerson(long id) {
		String result = "";
		Person personForDelete = personRepository.findById(id).orElse(null);
		if(personForDelete != null) {
			personRepository.deleteById(id);
			result = "삭제 완료";
		} else {
			result = "삭제 대상 없음";
		}
		return result;
	}
	
	public List<Person> selectAll() {
		
		return personRepository.findAll();
	}
	
	public Person selectByName(String name) {
		return personRepository.findByName(name);
	}
	
	public List<Person> selectByNameOrAgeJPQL(int age, String name) {
		return personRepository.getByAgeOrName(age, name);
	}
	
	public String updatePerson(String name, String newName, int newAge) { 
		
		Person person = personRepository.findByName(name);
		
		person.setName(newName);
		person.setAge(newAge);
		
		personRepository.save(person);
		
		return "수정 완료";
		
	}
}
