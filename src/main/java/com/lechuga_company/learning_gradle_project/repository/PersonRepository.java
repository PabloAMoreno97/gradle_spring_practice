package com.lechuga_company.learning_gradle_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lechuga_company.learning_gradle_project.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
