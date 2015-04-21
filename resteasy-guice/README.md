# Resteasy-guice module
#### Shows how to integrate guice and guice persist with resteasy.

#### Goal

The goal of this module is to show one how to write a simple rest service using Guice and RESTEasy. 
[Guice](https://github.com/google/guice) is a lightweight dependency injection framework developed by Google.
[RESTEasy](https://github.com/resteasy/Resteasy) is project provided by JBoss that allows you to easily develop RESTful web services.
You can read more about [REST in RESTful Java with JAX-RS 2.0](http://shop.oreilly.com/product/0636920028925.do) by Bill Burke  
    
I will demonstrate how to configure and run integration tests against your service using maven and tomcat so that it forms part of your build cycle. 
    

Note: When using guice's persist extension you must use it's own Transactional annotation and 
not the javax.transaction.Transactional as it causes inconsistent/unexpected results.
