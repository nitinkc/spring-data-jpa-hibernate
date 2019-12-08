# Spring 5 Learning

use Docker to run the DB

docker pull mysql

docker run -d
--name=mysql_learning
--env="MYSQL_ROOT_PASSWORD=root"
--env="MYSQL_PASSWORD=root"
-v /Users/nitin/Downloads/docker_data:/var/lib/mysql
-p=3306:3306
mysql

docker exec -it mysql_learning mysql -uroot -p

## Brew Mysql
mysql.server start
# spring-data-jpa

Add different packages via Component Scan
```java
@ComponentScan(basePackages = {"cPersistenceContext", "com.learningJPA"})
```

## Spring Data JPA
Removes the need of using Entity Manager in persistence context. Spring Data JPA can talk to the Entity Manager and provides 
the required method implementation