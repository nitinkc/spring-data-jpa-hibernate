package com.learningJPA.dSpringDataRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Entity that needs to be managed is Student given in <>
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<List<Student>> findByCityOfBirth(String city);

    //Works with H2 Database
    @Query(value = "SELECT a.*  FROM STUDENT a where EXTRACT(YEAR FROM a.dob) = ?1",nativeQuery = true)
    Optional<List<Student>> findByYearOfBirth(int year);

    Optional<List<Student>> findByGenderAndAndCityOfBirth(String gender, String city);

}
