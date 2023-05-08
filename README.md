# Spring JPA Repositories, JPQL
### Слой DAO c JPA Repositories

![HIBERNATE](https://bs-uploads.toptal.io/blackfish-uploads/components/seo/content/og_image_file/og_image/777051/1206-Hibernate_Almost_Ruined_My_Career_Dan_Social-bacb31d1cb97c9960b9a08bd85c5dbb5.png "HIBERNATE JAVA")

## Как это работает 
При запуске приложения создаётся таблица <code>Persons</code> и в неё добавляются демо данные.
После этого доступны выборки из БД по адресу <code>localhost:8080/persons/{endpoint}?{params}</code>

| Endpoint         |  Параметры   |                                                                                                        Пример |
|:------------------|:------------:|:--------------------------------------------------------------------------------------------------------------|
| <code>/by-city</code>         |     city     |[/by-city?city=moscow](localhost:8080/persons/by-city?city=moscow) |
| <code>/by-age</code>          |     age      |[/by-age?age=34](localhost:8080/persons/by-age?age=34) |
| <code>/by-name-surname</code> | name,<br>surname |  [/by-name-surname?name=Olga&surname=Savina](localhost:8080/persons/by-name-surname?name=Olga&surname=Savina) |  

  
### Данные таблицы Persons

|  age  | name |  surname  |   city    |      phone      |
|:-----:|:----:|:---------:|:---------:|:---------------:|
|  11   |Trofim|  Petrov   |  SARATOV  |  +79001002020   |
|  19   |Olga|  Savina   |  MOSCOW   |  +79001002050   |
|  21   |Bill|  Dilling  | NEW YORK  |   79001002090   |
|  21   |David|  Dontro   |   ROME    |  +79001002070   |
|  21   |Egor|  Ivanov   |  MOSCOW   |  +79001002010   |
|  24   | Aleksey|  Vodonos  |  MOSCOW   |  +79001002080   |
|  69   | Stepan|  Egorov   |   OSLO    |  +79001002040   |

*Все данные вымышленные, представлены исключительно для демонстрации возможностей приложения* 





