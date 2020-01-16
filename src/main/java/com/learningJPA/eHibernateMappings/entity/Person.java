package com.learningJPA.eHibernateMappings.entity;

import javax.persistence.*;

/**
 * Created by nitin on Wednesday, January/15/2020 at 10:23 PM
 */

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fName;
    private String lName;
}
