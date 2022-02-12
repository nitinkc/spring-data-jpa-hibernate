package com.learningJPA.hibernate.multTab;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Apple {
	@Id
	private int appleId;
	private String appleLocation;
}
