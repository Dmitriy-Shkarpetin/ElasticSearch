package com.example.elasticsearch.controller;

import com.example.elasticsearch.document.Person;
import com.example.elasticsearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id) {
        return personService.searchById(id);
    }

    @PostMapping
    public void savePerson(@RequestBody Person person) {
        personService.save(person);
    }
}
