package com.example.jpatest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jpatest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	//메서드 이름 기반 쿼리 생성
	/*
	 * example
	 * findByAgeGreaterThan -> where age > ?
	 * findByNameAndAge -> where name = ? and age = ?
	 * findByNameOrAge -> where name = ? or age = ?
	 * findByNameLike -> where name like ?
	 * findByAgeBetween(int start, int end) -> where age between start and end
	 * findyAgeIn -> where age in (..., ..., ......)
	 * findAllByName -> List
	 * findAllByOrderByNameAsc
	 * ...
	 * ...
	 * */
	Person findByName(String name);
	
	
	//JPQL
	@Query("select p from Person p where p.age = :age or p.name = :name")
	List<Person> getByAgeOrName(int age, String name);
}
