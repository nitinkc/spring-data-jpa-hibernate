package com.learningJPA.hibernate.inheritance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

/* No Primary key in the main table */

@Entity
@Inheritance
@DiscriminatorValue(value="Light_Summers")
@Getter
@Setter
public class SummerFruits extends Fruits {
	private String name;
	private String taste;
}
