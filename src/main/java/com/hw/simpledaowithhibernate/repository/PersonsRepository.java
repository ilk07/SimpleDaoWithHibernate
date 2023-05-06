package com.hw.simpledaowithhibernate.repository;

import com.hw.simpledaowithhibernate.entity.Person;

import java.util.List;

public interface PersonsRepository {
    List<Person> getPersonsByCity(String city);
}
