# PA Lab 11

Authors: Barat Narcis Stefan and Coteanu Maria

REST Services

Continue the application created at the previous lab integrating the following functionalities:

- Create a database in order to store the persons and their social network relationships.
- Implement REST services needed to comunicate with the database (CRUD).

The main specifications of the application are:

## Compulsory

- &#9744; Create a Spring Boot project containing the REST services for comunicating with the database.
- &#9744; Create the class Person.
- &#9744; Create a REST controller containing methods for:
    - obtaining the list of the persons, via a HTTP GET request.
    - adding a new person in the database, via a HTTP POST request.
    - modifying the name of a person, via a HTTP PUT request.
    - deleting a person, via a HTTP DELETE request.
- &#9744; Test your services using the browser and/or Postman.

## Optional

- &#9744; Create REST services for inserting and reading relationships.
- &#9744; Create services for determining the first k most/least connected (popular) persons in the network.
- &#9744; Integrate the services into your previous project, invoking them using the support offered by Spring Boot.
- &#9744; Handle the exceptions using a RestControllerAdvice.

## Bonus

- &#9744; Write a service that determines in linear time all persons who are so important to the social network such that, if one of them were eliminated, the network would become disconnected.
- &#9744; Document your services using Swagger or a similar tool.
- &#9744; Secure your services using the HTTPS protocol and JSON Web Tokens