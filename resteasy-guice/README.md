## Resteasy-guice
#### Shows how to integrate guice and guice persist with resteasy.

#### Goal

The goal of this module is to show one how to write a simple rest service using Guice and RESTEasy. 
[Guice](https://github.com/google/guice) is a lightweight dependency injection framework developed by Google.
[RESTEasy](https://github.com/resteasy/Resteasy) is project provided by JBoss that allows you to easily develop RESTful 
web services. You can read more about REST in [RESTful Java with JAX-RS 2.0](http://shop.oreilly.com/product/0636920028925.do) 
by Bill Burke.  
    
I demonstrate how to configure and run integration tests against your service using maven and tomcat so that it forms 
part of your build cycle.
 
This application demonstrates an end-to-end application from the Rest resource all the way through to a service layer that 
integrates to a database. JPA/Hibernate is used to as the persistence implementation and Guice to bootstrap the lot. 
See [guice-persistence](https://github.com/DonC83/learn/tree/master/guice-persistence) to see how Guice and JPA work together.
 
I've chosen to use HSQLDB in my example to illustrate how to test against a database without the need to have one 
installed/configured and loaded with the database and test data. The entire module should be able to build successfully after
cloning. 
  
    

Note: When using guice's persist extension you must use it's own Transactional annotation and 
not the javax.transaction.Transactional as it causes inconsistent/unexpected results.
