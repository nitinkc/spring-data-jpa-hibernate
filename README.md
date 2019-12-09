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
@ComponentScan(basePackages = {"com/learningJPA/cPersistenceContext", "com.learningJPA"})
```

## Spring Data JPA
Removes the need of using Entity Manager in persistence context. Spring Data JPA can talk to the Entity Manager and provides 
the required method implementation

## Initial Data Setup
placing the data into data.sql file in Resources folder

## Using CrudRepositiry
```java
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
```

### Using this Repo (Service) in the Controller Class

```java
@RestController
public class StudentController {

    @Autowired
    private StudentRepository userRepository;

    @GetMapping("/jpa/users")
    public List<Student> retrieveAllUsers(){
        return userRepository.findAll();
    }
}
```

Verify the data connectivity from GET Request

http://localhost:8080/jpa/users

