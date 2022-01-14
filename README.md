# openapi-generation

Reproduce generate-simpleserver-spring:
  - Either Run mvn clean install in your package
  - Or in Eclipse: mvn install, maven update project
  - This will generate the folder "target/generated-sources/openapi/src/main/java" with the generated API-implementation in it.
  - Run org.openapitools.OpenAPI2SpringBoot.java which will spin up the generated SpringBoot-Server
  - To test it run "curl -I http://localhost:8080/books/" in cmd. It will return HTTP-Statuscode 501 (Not Implemented), because only a server stub was genereted. The Logic is missing.

Reproduce generate-responseserver-spring:
  - Target was puhed for this project, because the inner logic of the service was added to BooksApiDelegate.
  - Run org.openapitools.OpenAPI2SpringBoot.java
  - To test it run "curl -I http://localhost:8080/books/" in cmd. It will return HTTP-Statuscode 200 (Ok). The inner logic was added, but the map this response is based on, is empty.
