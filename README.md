# JPA. ORM, Hibernate (минусы и плюсы), Entity Lifecycle, Embedding, Relationships
### Слой DAO c Hibernate

![HIBERNATE](https://bs-uploads.toptal.io/blackfish-uploads/components/seo/content/og_image_file/og_image/777051/1206-Hibernate_Almost_Ruined_My_Career_Dan_Social-bacb31d1cb97c9960b9a08bd85c5dbb5.png "HIBERNATE JAVA")

Мини-приложение работы с БД, используя средства Spring конфигурации и Hibernate, 
создаёт таблицу <code>Persons</code> и получает из неё список пользователей по запросу названия города. 

Spring Boot приложение:
- с мини-репозиторием для работы с БД и единственным 
методом <code>getPersonsByCity(String city)</code>, который принимает название города (city) и возвращает
список людей, соответствующих этому 'city'.  
- с контроллером с методом-обработчиком GET-метода запроса с маппингом на endpoint /persons/by-city. 
Метод уметь обрабатывать запрос вида <code>localhost:8080/persons/by-city?city=Moscow</code>
 
