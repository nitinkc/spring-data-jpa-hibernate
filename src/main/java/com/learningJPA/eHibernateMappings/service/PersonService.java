package com.learningJPA.eHibernateMappings.service;

import com.learningJPA.eHibernateMappings.entity.Person;
import com.learningJPA.eHibernateMappings.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nitin on Wednesday, January/15/2020 at 11:16 PM
 */

@Service
public class PersonService {

    private PersonRepository studentRepository;
    public PersonService(PersonRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Person> allStudents(){
        return studentRepository.findAll();
    }

}
