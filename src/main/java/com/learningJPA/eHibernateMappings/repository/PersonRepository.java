package com.learningJPA.eHibernateMappings.repository;

import com.learningJPA.eHibernateMappings.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nitin on Wednesday, January/15/2020 at 11:14 PM
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
