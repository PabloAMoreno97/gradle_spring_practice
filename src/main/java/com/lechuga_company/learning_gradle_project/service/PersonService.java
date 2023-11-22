package com.lechuga_company.learning_gradle_project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lechuga_company.learning_gradle_project.model.Person;
import com.lechuga_company.learning_gradle_project.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;
    
    public List<Person> getPersonList(){
        return personRepository.findAll();
    }

    public Person savePerson(Person person){
        personRepository.save(person);
        return person;
    }

    public Person getPerson(Long id){
        Person person = personRepository.findById(id).orElse(null);
        return person;
    }

}
