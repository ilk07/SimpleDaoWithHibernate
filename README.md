# JPA. ORM, Hibernate (минусы и плюсы), Entity Lifecycle, Embedding, Relationships
### Миграции c Hibernate

![db simple blue](https://blog.nimbleways.com/content/images/2021/04/Liquibase.jpg "")

Spring Boot приложение создаёт таблицу <code>Persons</code> и получает из неё список пользователей по запросу 
названия города вида <code>localhost:8080/persons/by-city?city=Moscow</code>.

Приложение при работе использует Hibernate и Liquibase.
 
