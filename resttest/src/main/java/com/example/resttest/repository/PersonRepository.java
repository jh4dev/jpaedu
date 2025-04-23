package com.example.resttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resttest.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
