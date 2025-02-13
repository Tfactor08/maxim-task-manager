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

## Testing endpoints

To test the provided endpoints:
1. Make the scripts executable:
```bash
chmod u+x test-api-*
```
2. To test the /tasks GET method:
```bash
./test-api-get.sh
```
3. To test the /tasks POST method (will create a new task with the title "test-task"):
```bash
./test-api-post.sh
```
