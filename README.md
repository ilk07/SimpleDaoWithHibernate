# Безопасность в веб-приложениях, Spring Security
## Безопасные методы

![Spring Security](https://technicalsand.com/wp-content/uploads/2020/09/Spring-security.png "Spring Security")


## Безопасность - модель ролей
У пользователей теперь есть только роли (одна или несколько) для работы с данными.
Возможность выполнить тот или иной запрос определяется ролью пользователя, - делаем методы безопасными. 

**Пользователи и роли** 

|  Логин  | Пароль | Роль                | 
|:-----:|:----:|:--------------------|
|  Eli   | password | READ, WRITE, DELETE | 
|  John   | password | READ, WRITE         |  
|  Anna   | password | READ                |


## Endpoint и запросы 
Во всех случаях для отправки запросов с endpoint адресов нужна аутентификация с помощью логина и пароля. 

Безопасность реализована на уровне методов RestController с помощью аннотаций.

**Доступность endpoint для ролей**

| Endpoint                      |     Роль     | Пользователь | Аннотация      |
|:------------------------------|:------------:|:-------------|:---------------|
| <code>/getInfo</code>         |     ALL      | ALL          | -              |
| <code>/by-username</code>     |     ALL      | ALL          | @PostAuthorize |
| <code>/by-city</code>         |     READ     | ALL          | @Secured       |
| <code>/by-age</code>          |    WRITE     | Eli, John    | @RolesAllowed  | 
| <code>/by-name-surname</code> | READ, DELETE | ALL          | @PreAuthorize  |

*Endpoint '/by-username' ожидает указания в параметре username имени пользователя, 
который отправляет запрос.


## Как это работает
При запуске приложения создаётся таблица <code>Persons</code> и в неё добавляются демо данные.
После этого доступны выборки из БД по адресу <code>localhost:8080/persons/{endpoint}?{params}</code>

| Endpoint         |    Параметры     | Пример                                                                                                       |
|:------------------|:----------------:|:-------------------------------------------------------------------------------------------------------------|
| <code>/by-city</code>         |       city       | [/by-city?city=moscow](localhost:8080/persons/by-city?city=moscow)                                           |
| <code>/by-age</code>          |       age        | [/by-age?age=34](localhost:8080/persons/by-age?age=34)                                                       |
| <code>/by-name-surname</code> | name,<br>surname | [/by-name-surname?name=Olga&surname=Savina](localhost:8080/persons/by-name-surname?name=Olga&surname=Savina) |
| <code>/by-username</code> |     username     | [/by-username?name=anna](localhost:8080/persons/by-username?name=anna)                                                            |


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





