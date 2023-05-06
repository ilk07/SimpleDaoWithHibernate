package com.homeworks.simpledaohibernatemigrations.controller;

import com.homeworks.simpledaohibernatemigrations.entity.Person;
import com.homeworks.simpledaohibernatemigrations.repository.impl.PersonsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonsController {
    @Autowired
    PersonsRepositoryImpl repository;

    @GetMapping("/by-city")
    public List<Person> getPersonByCity(@RequestParam(required = true) String city) {
        return repository.getPersonsByCity(city);
    }
}