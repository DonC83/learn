## Guice Persistence Example

The aim of this example is to demonstrate how to make use of HSQLDB (http://www.hsqldb.org/) to provide a database for
testing without the need to have a specific database application pre-installed (MySQL, Postgres etc)

The application is shows how to hsqldb in-memory catalog as described by the hsqldb documentation:

> "mem: stored entirely in RAM - without any persistence beyond the JVM process's life"

The application is simple using JPA/Hibernate to illustrate database persistence and as well as
Google Guice to bootstrap the application and provide Dependency Injection (DI).

