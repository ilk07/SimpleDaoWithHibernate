package com.hw.simpledaowithhibernate.controller;

import com.hw.simpledaowithhibernate.entity.Person;
import com.hw.simpledaowithhibernate.repository.impl.PersonsRepositoryImpl;
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