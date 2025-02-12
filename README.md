# maxim-task-manager

## Application Configuration

Below is an example of a `application.properties` file for a Spring Boot application:

```properties
spring.application.name=TaskManager

spring.datasource.url=jdbc:sqlite:tasks.db
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.datasource.username=
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
spring.jpa.hibernate.ddl-auto=update
```
