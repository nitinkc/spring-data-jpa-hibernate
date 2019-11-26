package dSpringDataRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentControllerJPAResource {

	@Autowired
	private StudentRepository studentRepository;

	// Retrieve all users
	@GetMapping(path = "jpa/students")
	public List<Student> retrieveAllUsers() {
		System.out.println("Testing");

		return studentRepository.findAll();
	}

	// Retrieve specific users
	@GetMapping(path = "jpa/student/{id}")
	public Resource<Student> retrieveUserById(@PathVariable int id) {
		Optional<Student> std = studentRepository.findById(id);

		if (!std.isPresent())
			try {
				throw new Exception("Id is : " + id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		Resource<Student> resource = new Resource<Student>(std.get());
		return resource;
	}
	
	@DeleteMapping("/jpa/student/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentRepository.deleteById(id);
		
	}
	
	@PostMapping("/jpa/student")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student){
		Student savedStud = studentRepository.save(student);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStud.getId())
				.toUri();
		
		return (ResponseEntity<Object>) ResponseEntity.created(location);
	}
	
	// Retrieve all the posts of a user
	@GetMapping(path = "jpa/student/{id}/posts")
	public List<Post> retrievePostById(@PathVariable int id) {
		Optional<Student> std = studentRepository.findById(id);

		if (!std.isPresent())
			try {
				throw new Exception("Id is : " + id);
			} catch (Exception e) {
				e.printStackTrace();
			}

		return std.get().getPosts();
	}
}
