# Medical Clinic Spring
Spring-based web application for facilitating the management of medical clinic.

## Technologies
- Java 11
  - Hibernate
  - Spring Boot 2.3.3
  - Spring Security
  - JUnit 4
  - Mockito
  - Spring Test
- PostgreSQL (13.1-alpine, pgAdmin 4)
- Thymleaf
- HTML+CSS (Bootstrap) 
- Maven
- Docker

## Running the application

### Spring Application
As written above you need JDK 11 or above installed on your computer in order to develop the app. Updating maven project will download and install all needed libraries.

### Database
While developing the app we used database that was runnig inside Docker image. You need to run docker locally and then execute:
```
docker-compose up
```
on `docker-compose.yml` file.

GUI will be available on `localhost:8080`.

## Features

The implementation of the design task assumed the creation of an internet application enabling the management of a medical clinic. The following roles are distinguished among the actors of the system:

- nurse (clinic worker),
- doctor,
- lab worker,
- patient (client).

A clinic employee can add clients to the database and edit selected data. Moreover, the competences of nurses include scheduling and canceling visits.

Each patient has an assigned, separate account to which he can log in using the website. The client can order an appointment with a given doctor on a given day. The user has the possibility to view his own visit schedule.
