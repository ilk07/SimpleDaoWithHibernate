/*
Напишите новый контроллер, в котором:
- один из методов возвращает значения только для пользователей с ролью "READ" (используйте @Secured);
- один из методов возвращает значения только для пользователей с ролью "WRITE" (используйте @RolesAllowed);
- один из методов возвращает значения, если у пользователя есть хотя бы одна из ролей из "WRITE", "DELETE" (используйте pre/post аннотации);
- один из методов, который принимает в качестве query-параметра имя пользователя (username),
должен возвращает значения, только если у пользователя username совпадает с именем пользователя в вашем объекте
Authentication, который Spring security сохраняет в SecurityContextHolder после успешной аутентификации.*
*/
package com.homeworks.simpledaolayerhibernatejpa.controller;

import com.homeworks.simpledaolayerhibernatejpa.entity.Person;
import com.homeworks.simpledaolayerhibernatejpa.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
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

    @Secured({"ROLE_READ"})
    @GetMapping("/by-city")
    public Optional<List<Person>> getPersonByCity(@RequestParam(required = false) String city) {
        return Optional.ofNullable(personsRepository.findByCity(city));
    }

    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/by-age")
    public Optional<List<Person>> getPersonByAgeLess(@RequestParam(required = true) int age) {
        if (age >= 0) {
            return Optional.ofNullable(personsRepository.findByAgeLessThanOrderByAgeAsc(age));
        }
        return null;
    }

    @PreAuthorize("hasAnyRole('READ','DELETE')")
    @GetMapping("/by-name-surname")
    public Optional<Person> getPersonByNameSurname(@RequestParam(required = false) String name, String surname) {
        return personsRepository.findByNameAndSurname(name, surname);
    }

    @PostAuthorize("#username.equalsIgnoreCase(authentication.principal.username)")
    @GetMapping("/by-username")
    public String checkUsername(@RequestParam String username) {
        return "Ok";
    }

}

