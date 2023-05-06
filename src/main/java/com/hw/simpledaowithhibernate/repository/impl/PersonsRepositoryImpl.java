package com.hw.simpledaowithhibernate.repository.impl;

import com.hw.simpledaowithhibernate.entity.Person;
import com.hw.simpledaowithhibernate.repository.PersonsRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonsRepositoryImpl implements PersonsRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        List<?> list = entityManager.createQuery("SELECT person from Person person where person.city = ?1")
                .setParameter(1, city)
                .getResultList();
        return (List<Person>) list;
    }
}
