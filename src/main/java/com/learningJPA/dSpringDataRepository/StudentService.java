package com.learningJPA.dSpringDataRepository;

import com.learningJPA.dSpringDataRepository.studentException.StudentNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by nichaurasia on Thursday, January/16/2020 at 11:57 AM
 */

@Service
public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> retrieveAllUsers() {
        return studentRepository.findAll();
    }

    public List<Student> retrieveAllUsersPagination(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Student> pagedResult = studentRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Student>();
        }
    }


    public Student retrieveStudentById(@PathVariable("id") @NotBlank Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("id:" + id));

		/*
			Optional<Student> optional = studentRepository.findById(id);
			if (!optional.isPresent()){
				throw new StudentNotFoundException("id:" + id);
			}

			Student foundStudent = optional.get();
			return foundStudent;
		*/
    }

    public List<Student> retrieveStudentByCityOfBirth(@PathVariable("city") String city) {
        return studentRepository.findByCityOfBirth(city)
                .orElseThrow(() -> new StudentNotFoundException("city:" + city));
    }


    public Student deleteStudent(@PathVariable Long id) {
        Optional<Student> optional = studentRepository.findById(id);

        if(optional.isPresent()){
            studentRepository.deleteById(id);
        }

        return optional.get();
    }

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

    public Student modifyValue(@RequestBody Student newStudent, @PathVariable Long id){
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(newStudent.getFirstName());
                    student.setDob(newStudent.getDob());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }
}
