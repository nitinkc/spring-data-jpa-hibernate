package com.learningJPA.hibernate.inheritance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
@DiscriminatorValue("Hard_Winter_Fruits")
@Getter
@Setter
public class WinterFruits extends Fruits{
	private boolean isAvailable;
	private String name;
}
