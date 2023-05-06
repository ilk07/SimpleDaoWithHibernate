package com.homeworks.simpledaohibernatemigrations.repository;

import com.homeworks.simpledaohibernatemigrations.entity.Person;

import java.util.List;

public interface PersonsRepository {
    List<Person> getPersonsByCity(String city);
}