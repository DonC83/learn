README

This project is an example of how I setup a RESTful application using Jersey 1.x and Guice 3.0.
I use Guice as the DI framework for injection purposes.

To generate this project from scratch run the following maven command

mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeGroupId=com.sun.jersey.archetypes
-DarchetypeVersion=1.18.1


The archetype automatically adds the following dependency into the pom :
        <dependency>
             <groupId>org.glassfish.extras</groupId>
             <artifactId>glassfish-embedded-web</artifactId>
             <version>${glassfish.version}</version>
             <scope>test</scope>
         </dependency>
If you are not using glassfish to do your testing I would suggest removing it or commenting it out, it seems to cause
eclipselink to overwrite hibernate as the orm persistence provider when running tests, but only if it's placed above
hibernate dependency in the pom file.
