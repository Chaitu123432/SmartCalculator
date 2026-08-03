# Maven Answers

## B2.1

The phases executed by `mvn package` are:

1. validate
2. compile
3. test
4. package

## B2.2

`mvn package` compiles, tests, and packages the project into a JAR/WAR.

`mvn install` performs all the package steps and additionally installs the built artifact into the local Maven repository so that other local projects can use it.

## B2.3

JUnit should use the `test` scope because it is only needed during testing. It is not required in the application's production runtime, reducing the final package size and avoiding unnecessary dependencies.