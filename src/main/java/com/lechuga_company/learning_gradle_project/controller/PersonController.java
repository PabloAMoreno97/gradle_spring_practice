package com.lechuga_company.learning_gradle_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lechuga_company.learning_gradle_project.model.Person;
import com.lechuga_company.learning_gradle_project.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    
    @GetMapping("")
    public List<Person> getListPerson(){
        return personService.getPersonList();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Person postPerson(@RequestBody Person person){
        return personService.savePerson(person);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }
    
}
