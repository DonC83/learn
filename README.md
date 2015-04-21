# My Learning

* Postgres
* HyperSQL DB
* Jersey REST
* Google Guice
* RestEasy

# Resteasy-guice module
#### Shows how to integrate guice and guice persist with resteasy.

Note: When using guice's persist extension you must use it's own Transactional annotation and 
not the javax.transaction.Transactional as it causes inconsistent/unexpected results.


#### JDK hints 
Use java's try-with-resources which was introduced in jdk7 [See here](www.docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)
