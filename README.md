# openapi-generation

Reproduce generate-simpleserver-spring and generate-delegateserver-spring:
  - Either Run mvn clean install in your package
  - Or in Eclipse: mvn install, maven update project
  - This will generate the folder "target/generated-sources/openapi/src/main/java" with the generated API-implementation in it.
  - Run org.openapitools.OpenAPI2SpringBoot.java which will spin up the generated SpringBoot-Server
  - To test it run "curl -I http://localhost:8080/books/" in cmd. It will return HTTP-Statuscode 501 (Not Implemented), because only a server stub was genereted. The Logic is missing.

generated-delegateserver-spring contains the generated server with configuration options for "delegatePattern" and "useOptional" set to true. The inner (happy path) logic is implemented in the class "BookStorageService".

generated-server-test contains the clientSystem, as well as the tests run on the generated servers
