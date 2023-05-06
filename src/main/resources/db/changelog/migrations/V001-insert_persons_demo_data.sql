--liquibase formatted sql

--changeset ilk07:2
insert into persons (name, surname, age, phone_number, city_of_living) values ('Bill', 'Dilling', '21', '+79001002090', 'NEW YORK');
insert into persons (name, surname, age, phone_number, city_of_living) values ('David', 'Dontro', '21', '+79001002070', 'ROME');
insert into persons (name, surname, age, phone_number, city_of_living) values ('Stepan', 'Egorov', '69', '+79001002040', 'OSLO');
insert into persons (name, surname, age, phone_number, city_of_living) values ('Egor', 'Ivanov', '21', '+79001002010', 'MOSCOW');
insert into persons (name, surname, age, phone_number, city_of_living) values ('Trofim', 'Petrov', '11', '+79001002020', 'SARATOV');
insert into persons (name, surname, age, phone_number, city_of_living) values ('Olga', 'Savina', '19', '+79001002050', 'MOSCOW');
insert into persons (name, surname, age, phone_number, city_of_living) values ('Aleksey', 'Vodonos', '24', '+79001002080', 'MOSCOW');

--rollback truncate table persons

