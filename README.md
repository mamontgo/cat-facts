# Cat Facts


### Perquisites

Java 8 +

Maven 3 + 

*I have not tested this on Java 11 so may fail on that JDK*

### Project Structure

This is a multi module project with a standard service facade pattern

/cat-demo-data (Data Layer JPA/Hibernate)

/cat-demo-service (Service/Business logic layer)

/cat-demo-controller (web service layer)

/cat-demo-boot (Application package)



### Build Project
```
mvn clean install
```


### Start Server

```sh
cd cat-demo-boot
mvn spring-boot:run
```


### Testing
When built with tests code coverage reports will be published for each sub module:

/cat-demo-data/target/site/jacoco/index.html

/cat-demo-service/target/site/jacoco/index.html

/cat-demo-controller/target/site/jacoco/index.html

/cat-demo-boot/target/site/jacoco/index.html


### BDD Integration Testing
I added some Cucumber BDD integration tests to the cat-demo-boot module.
The feature definitions can be found in:

/cat-demo-boot/src/test/resources

There are 2 features defined one for getting a single Fact and another for getting all the facts

When built the Cucumber BDD report can be found here:

/cat-demo-boot/target/local-html-report/index.html

