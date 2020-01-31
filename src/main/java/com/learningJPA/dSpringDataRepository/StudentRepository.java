package com.learningJPA.dSpringDataRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Entity that needs to be managed is Student given in <>
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<List<Student>> findByCityOfBirth(String city);
}
