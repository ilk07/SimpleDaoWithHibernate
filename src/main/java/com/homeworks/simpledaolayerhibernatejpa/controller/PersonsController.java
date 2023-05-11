package com.homeworks.simpledaolayerhibernatejpa.controller;

import com.homeworks.simpledaolayerhibernatejpa.entity.Person;
import com.homeworks.simpledaolayerhibernatejpa.repository.PersonsRepository;
import com.sun.istack.NotNull;
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

    @GetMapping()
    public String getInfo() {
        return "Hi! To get data by city, name or age, please, login";
    }

    @GetMapping("/by-city")
    public List<Person> getPersonByCity(@RequestParam(required = false) String city) {
        return personsRepository.findByCity(city);
    }


    @GetMapping("/by-age")
    public List<Person> getPersonByAgeLess(@RequestParam(required = false) int age) {
        return personsRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/by-name-surname")
    public Optional<Person> getPersonByNameSurname(@RequestParam(required = false) String name, String surname) {
        return personsRepository.findByNameAndSurname(name, surname);
    }

}

