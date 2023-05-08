package com.homeworks.simpledaolayerhibernatejpa.repository;

import com.homeworks.simpledaolayerhibernatejpa.entity.Person;
import com.homeworks.simpledaolayerhibernatejpa.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Person, PersonId> {

    List<Person> findByCity(String city);
    List<Person> findByAgeLessThanOrderByAgeAsc(int age);
    Optional<Person> findByNameAndSurname(String name, String surname);


}