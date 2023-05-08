package com.homeworks.simpledaolayerhibernatejpa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode
@Table(name = "Persons")
@IdClass(PersonId.class)
public class Person implements Serializable {

    @Id
    @Column(nullable = false)
    private String name;

    @Id
    @Column(nullable = false)
    private String surname;

    @Id
    @Column(nullable = false)
    private int age;

    @Column(nullable = false, name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(nullable = false, name = "city_of_living")
    private String city;

}
