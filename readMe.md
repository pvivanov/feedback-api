## Your first API
Spring Boot, MySQL, JPA, Hibernate

### Presets and setup steps
* install jdk8
* install lombok plugin
* customize lombok plugin (Build, Execution, Deployment --> Compiler --> Annotation Processors, Enable annotation processing)
* Setup MySQL & Create Mysql database
```
create database feedback_app
```
* change mysql username and password as per your installation if you want

> open `src/main/resources/application.properties`

> change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

* start mySQL Server in comand line
```
mysql.server start
```
* run FeedbackApplication or build application with gradle
* explore your API
```
  GET /api/feedback

  POST /api/feedback

  GET /api/feedback/{noteId}

  PUT /api/feedback/{noteId}

  DELETE /api/feedback/{noteId}
```
* using curl, postman or any other rest client.
> for examle, on localhost GET request `localhost:8080/api/feedback/` or POST request `localhost:8080/api/feedback/` with raw JSON body `{
"id" : "",
"title" : "example",
"content" : "Hello"
}`
* enjoy...