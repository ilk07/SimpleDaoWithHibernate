package com.hw.simpledaowithhibernate;

import com.hw.simpledaowithhibernate.entity.Person;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SimpleDaoWithHibernateApplication implements CommandLineRunner {

    @PersistenceContext
    EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SimpleDaoWithHibernateApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }

    @Transactional
    @Override
    public void run(String... args) {

        List<Person> personList = new ArrayList<>();

        personList.add(Person.builder()
                .name("Bill")
                .surname("Dilling")
                .age(21)
                .phoneNumber("79001002090")
                .city("NEW YORK")
                .build());

        personList.add(Person.builder()
                .name("David")
                .surname("Dontro")
                .age(21)
                .phoneNumber("+79001002070")
                .city("ROME")
                .build());

        personList.add(Person.builder()
                .name("Stepan")
                .surname("Egorov")
                .age(69)
                .phoneNumber("+79001002040")
                .city("OSLO")
                .build());

        personList.add(Person.builder()
                .name("Egor")
                .surname("Ivanov")
                .age(21)
                .phoneNumber("+79001002010")
                .city("MOSCOW")
                .build());

        personList.add(Person.builder()
                .name("Trofim")
                .surname("Petrov")
                .age(11)
                .phoneNumber("+79001002020")
                .city("SARATOV")
                .build());

        personList.add(Person.builder()
                .name("Olga")
                .surname("Savina")
                .age(19)
                .phoneNumber("+79001002050")
                .city("MOSCOW")
                .build());

        personList.add(Person.builder()
                .name("Aleksey")
                .surname("Vodonos")
                .age(24)
                .phoneNumber("+79001002080")
                .city("MOSCOW")
                .build());

        personList.forEach(person -> entityManager.persist(person));

    }
}
