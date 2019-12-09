#Basic Rest Calls

## Using CrudRepositiry
```java
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
```

### Using this Repo (Service) in the Controller Class to perform CRUD Operations


##### Get a list of all the users
```java
@RestController
@RequestMapping("/jpa")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	// Retrieve all users
	@GetMapping(path = "/students")
	public List<Student> retrieveAllUsers() {
		System.err.println("###################################### Retrieving All Users ######################################");
		return studentRepository.findAll();
	}
}
```

Verify the data connectivity from GET Request

[http://localhost:8080/jpa/users]

##### Get a user based on id (from get request parameter)

In Controller, Support of the use of Java 8 OPTIONAL is required. 
```java
// Retrieve specific users
@GetMapping(path = "/student/{id}")
public Student retrieveUserById(@PathVariable("id") @NotBlank Long id) {
    Optional<Student> optional = studentRepository.findById(id);

    if (!optional.isPresent()){
        throw new StudentNotFoundException("id:" + id);
    }

    Student foundStudent = optional.get();
    return foundStudent;
}
```

http://localhost:8089/api/hardCodedData/user/1

Another Approach

```java
// Retrieve specific users
@GetMapping(path = "/student/{id}")
public Student retrieveUserById(@PathVariable("id") @NotBlank Long id) {
    return studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("id:" + id));
}
```