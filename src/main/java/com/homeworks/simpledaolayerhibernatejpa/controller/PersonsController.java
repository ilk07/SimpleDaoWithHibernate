package com.homeworks.simpledaolayerhibernatejpa.controller;

import com.homeworks.simpledaolayerhibernatejpa.entity.Person;
import com.homeworks.simpledaolayerhibernatejpa.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonsController {
    @Autowired
    PersonsRepository personsRepository;

    @GetMapping("/by-city")
    public List<Person> getPersonByCity(@RequestParam(required = true) String city) {
        return personsRepository.findByCity(city);
    }

    @GetMapping("/by-age")
    public List<Person> getPersonByAgeLess(@RequestParam(required = true) int age) {
        return personsRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/by-name-surname")
    public Optional<Person> getPersonByNameSurname(@RequestParam(required = true) String name, String surname) {
        return personsRepository.findByNameAndSurname(name, surname);
    }

}

