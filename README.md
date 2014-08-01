spring-batch-admin-spring-boot
================================

This is a a Spring Boot capsule of the standard [Spring Batch Admin](https://github.com/spring-projects/spring-batch-admin "Github") application of the [Spring Batch](http://projects.spring.io/spring-batch/ "SpringIO Page") team. 

With this capsule it is possible to run the **Spring Batch Admin** as a **Spring Boot** application instead of deploying it to a servlet container like tomcat.

As default configuration a local HSQLDB database is used for the batch metadata. 

This can be changed:

1. You have other HSQLDB properties?	
	* Just change the entries inside batch-hsql.properties
2. You prefer to use another database system?
 	* Delete the file batch-hsql.properties
 	* Add a new file batch-[*your-db*].properties (a template can be found in the root of spring-batch-core.jar)
 	* Set the property *ENVIRONMENT* in application.properties to *your-db* (means i.e. batch-oracle.properties with ENVIRONMENT=oracle)
 	
You can test the running application by starting the JUnit test class *BatchTest* that can be found in the test sources folder.

Feel free to use it. The current version of **Spring Batch Admin** can be modified in the pom.xml.