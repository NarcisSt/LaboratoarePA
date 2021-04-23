# PA Lab 8

Author: Barat Narcis Stefan

JDBC

Write an application that allows to connect to a relational database by using JDBC, submit SQL statements and display the results.

The main specifications of the application are:

## Compulsory
- &#9745; Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
- &#9745; Write an SQL script that will create the following tables:
    - movies: id, title, release_date, duration, score
    - genres: id, name (for example: Action, Drama)
    - an associative (junction) table in order to store each movie genres
- &#9745; Update pom.xml, in order to add the database driver to the project libraries.
- &#9745; Create a singleton class in order to manage a connection to the database.
- &#9745; Create DAO classes that offer methods for creating movies and genres, and finding them by their ids and names;
- &#9745; Implement a simple test using your classes.

## Optional
- &#9745; Create the necessary table(s) in order to store movie actors and directors in the database.
- &#9745; Create an object-oriented model of the data managed by the Java application.
- Create a tool to import data from a real dataset: IMDb movies extensive dataset or The Movies Dataset or other.
- For additional points, you may consider extending your model or generating suggestive HTML reports, based on the imported data.

## Bonus
- &#9745; Use a connection pool in order to manage database connections, such as C3PO, HikariCP or Apache Commons DBCP.
- &#9745; Using a ThreadPoolExecutor, create a (large?) number of concurrent tasks, each requiring a database connection in order to perform various SQL operations on the database.
 Analyze the behavior of the application when using the singleton connection versus the coonection pool approach.
Create a scenario in order to highlight the advantages of using a connection pool.
- Use Visual VM in order to monitor the execution of your application (attach screenshots).
- For additional points, you may consider creating a graphical user interface.

### Example
```bash
Commands:
 1. compulsory
 2. c_singleton
 3. c_conn_pool
 4. list
 5. quit
shell>>compulsory
Movie Movie{id=755, name='Titanic', releaseYear=1997, duration=140, score=9} inserted in the database!
Genre Genre{id=2966, name='Drama', movieId=755} inserted in the database!
Genre Genre{id=2967, name='Romantic', movieId=755} inserted in the database!
Movie Movie{id=756, name='The Godfather', releaseYear=1991, duration=180, score=10} inserted in the database!
Genre Genre{id=2968, name='Actiune', movieId=756} inserted in the database!
Genre Genre{id=2969, name='Drama', movieId=756} inserted in the database!
shell>>list
Commands:
 1. compulsory
 2. c_singleton
 3. c_conn_pool
 4. list
 5. quit
 shell>>quit

Process finished with exit code 0