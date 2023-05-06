--liquibase formatted sql

--changeset ilk07:1
create table persons
(
    name varchar(255) NOT NULL comment 'Имя',
    surname varchar(255) NOT NULL comment 'Фамилия',
    age smallint NOT NULL comment 'Возраст',
    phone_number varchar(20) comment 'Номер телефона',
    city_of_living varchar(255) comment 'Город проживания',
    primary key (name,surname,age)
);
--rollback drop table persons
