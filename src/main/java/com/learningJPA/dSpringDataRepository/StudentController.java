package com.learningJPA.dSpringDataRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.learningJPA.dSpringDataRepository.studentException.StudentNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/jpa")
public class StudentController {
	/*@Autowired
	private StudentDAOService studentDAOService;*/

	//Constructor Injection, NO NEED FOR @AUTOWIRED Annotation
	private StudentRepository studentRepository;
	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	// Retrieve all users
	@GetMapping(path = "/students")
	public List<Student> retrieveAllUsers() {
		System.err.println("###################################### Retrieving All Users ######################################");
		return studentRepository.findAll();
	}

	// Retrieve specific users
	@GetMapping(path = "/student/{id}")
	public Student retrieveUserById(@PathVariable("id") @NotBlank Long id) {
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("id:" + id));

		/*
			Optional<Student> optional = studentRepository.findById(id);
			if (!optional.isPresent()){
				throw new StudentNotFoundException("id:" + id);
			}

			Student foundStudent = optional.get();
			return foundStudent;
		*/
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
		System.err.println("###################################### POST Begins ######################################");
		Student savedStud = studentRepository.save(student);
		System.err.println("###################################### POST Ends ######################################");
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStud.getId())
				.toUri();
		
		return (ResponseEntity<Object>) ResponseEntity.created(location).build();
	}

	@PutMapping("/student/{id}")
	public Student modifyValue(@RequestBody Student newStudent, @PathVariable Long id){
		return studentRepository.findById(id)
				.map(student -> {
					student.setName(newStudent.getName());
					student.setDob(newStudent.getDob());
					return studentRepository.save(student);
				})
				.orElseGet(() -> {
					newStudent.setId(id);
					return studentRepository.save(newStudent);
				});
	}
}

