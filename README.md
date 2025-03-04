# maxim-task-manager

## Application Configuration

Below is an example of an `application.properties` file:

```properties
spring.application.name=TaskManager

spring.datasource.url=jdbc:sqlite:tasks.db
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.datasource.username=
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
spring.jpa.hibernate.ddl-auto=update
```

Example of an `application-test.properties` file:
```properties
# Enable H2 in-memory database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=
spring.datasource.password=

# Use H2 dialect for Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Automatically create and drop schema
spring.jpa.hibernate.ddl-auto=create-drop
```

## Testing endpoints

To test the provided endpoints:
1. Make the scripts executable:
    ```bash
    chmod u+x test-api-*
    ```
2. Test the /tasks GET method:
    - Get all tasks:
        ```bash
        ./test-api-get.sh
        ```
    - Get a single task with `id`
        ```bash
        ./test-api-get.sh [id]
        ```
3. Test the /tasks POST method (will create a new task with the title "test-task"):
    ```bash
    ./test-api-post.sh
    ```
4. Test the /tasks PUT method (will change the title of the task with the provided `id`):
    ```bash
    ./test-api-put.sh [id]
    ```
5. Test the /tasks DELETE method (will delete the task with the provided `id`):
    ```bash
    ./test-api-put.sh [id]
    ```
