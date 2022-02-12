package com.learningJPA.hibernate.inheritance;


import com.learningJPA.hibernate.utils.HibernateUtils;
import org.hibernate.Session;

/* The default strategy is Table Per Hierarchy. 
 * You can achieve this without using Annotation 
 * It Gives a Discriminatory Type as a connecting Column (Basically the names of the Class)
 * 
 * Can use any of the given types to have the feature. Just one Annotation will take care of everything
 *  @Inheritance(strategy = InheritanceType.JOINED)
 *  @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
 *  @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
 *  
 *  With @Table Per Class, have to declare the Primary key in each
 * 
 * the other types can be generated simply by changing
 * */
public class T1TabPerHierarchyTester {
	public static void main(String[] args) {
		Fruits fruits = new Fruits();
		SummerFruits summerFruits = new SummerFruits();
		WinterFruits winterFruits = new WinterFruits();
		
		fruits.setColor("Red");
		
		summerFruits.setName("Mango");
		summerFruits.setTaste("Sweet");
		
		winterFruits.setAvailable(true);
		winterFruits.setName("Guava");
		
		// Creating the basic initialization from another Class
		Session session = HibernateUtils.createSession();
		session.beginTransaction();
	
		session.save(fruits);
		session.save(summerFruits);
		session.save(winterFruits);
	
		session.getTransaction().commit();
		session.close();
	}
}