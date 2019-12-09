package com.learningJPA.dSpringDataRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/jpa")
public class StudentController {
	/*@Autowired
	private StudentDAOService studentDAOService;*/

	@Autowired
	private StudentRepository studentRepository;

	// Retrieve all users
	@GetMapping(path = "/students")
	public List<Student> retrieveAllUsers() {
		System.out.println("Testing");
		return studentRepository.findAll();
	}

	// Retrieve specific users
	@GetMapping(path = "/student/{id}")
	public Student retrieveUserById(@PathVariable Long id) {
		Optional<Student> optional = studentRepository.findById(id);

		if (!optional.isPresent())
			try {
				throw new Exception("Id is : " + id);
			} catch (Exception e) {
				e.printStackTrace();
			}

		Student foundStudent = optional.get();
		return foundStudent;
	}

	@DeleteMapping("/student/{id}")
	public Student deleteStudent(@PathVariable Long id) {
		Optional<Student> optional = studentRepository.findById(id);

		if(optional.isPresent()){
			studentRepository.deleteById(id);
		}

		return optional.get();
	}

	@PostMapping("/student")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student){
		Student savedStud = studentRepository.save(student);
		System.err.println("POST");
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStud.getId())
				.toUri();
		
		return (ResponseEntity<Object>) ResponseEntity.created(location);
	}

	// Retrieve all the posts of a user
	/*@GetMapping(path = "jpa/student/{id}/posts")
	public List<Post> retrievePostById(@PathVariable int id) {
		Optional<Student> std = studentRepository.findById(id);

		if (!std.isPresent())
			try {
				throw new Exception("Id is : " + id);
			} catch (Exception e) {
				e.printStackTrace();
			}

		return std.get().getPosts();
	}*/
}

