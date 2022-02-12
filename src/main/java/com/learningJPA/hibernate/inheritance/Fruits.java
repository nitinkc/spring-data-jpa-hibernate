package com.learningJPA.hibernate.inheritance;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Fruits")
@DiscriminatorColumn(
		// Sets the name of the DTYPE Field in the Table generated
		name = "FruitsClass"//,
		//discriminatorType = DiscriminatorType.STRING //OPTIONAL
		)

//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorValue(value="Fruit_Parent")
@Getter
@Setter
@Data
public class Fruits {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Fruit_Code")
	private int sNo;
	
	private String color;
}
