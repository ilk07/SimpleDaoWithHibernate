package com.homeworks.simpledaolayerhibernatejpa.repository;

import com.homeworks.simpledaolayerhibernatejpa.entity.Person;
import com.homeworks.simpledaolayerhibernatejpa.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Person, PersonId> {

    @Query("select person from Person person where person.city = :city")
    List<Person> findByCity(String city);

    @Query("select person from Person person where person.age < :age order by person.age asc")
    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    @Query("select person from Person person where person.name = :name and person.surname = :surname")
    Optional<Person> findByNameAndSurname(String name, String surname);

}