package com.learningJPA.hibernate.multCol;

/**
 * HAS-A Relationship between User class and Address Class
 * One Table for all the classes  
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Z1Tester {
	public static void main(String[] args) {
		
		/* 3 address that are used in the User Class*/
		H2EmpAddress myOfficeAddress=new H2EmpAddress();
		myOfficeAddress.setZipCode(12345);
		myOfficeAddress.setEmpCity("Fremont");
		
		H2EmpAddress homeAddress=new H2EmpAddress();
		homeAddress.setZipCode(54321);
		homeAddress.setEmpCity("Chicago");
		
		H2EmpAddress hisOfficeAddress=new H2EmpAddress();
		hisOfficeAddress.setZipCode(98765);
		hisOfficeAddress.setEmpCity("Seattle");
		
		/* each user has two addresses, can be null */
		H2Emp user1=new H2Emp();
		//U_id is automatically set
		user1.setEmpName("Roshej");
		user1.setHomeAddress(homeAddress);
		user1.setOfficeAddress(myOfficeAddress);
		
		H2Emp user2=new H2Emp();
		user2.setEmpName("Gulgule");
		user2.setHomeAddress(homeAddress);
		user2.setOfficeAddress(hisOfficeAddress);
		
		H2Emp user3=new H2Emp();
		user3.setEmpName("Biloo");
		user3.setHomeAddress(hisOfficeAddress);
		user3.setOfficeAddress(myOfficeAddress);
		
		//loading the hibernate.cfg.xml file details
		StandardServiceRegistry registry = null;
		SessionFactory sessionFactory = null;
		if (sessionFactory == null) {
			try {
				// Creating a registry
				registry = new StandardServiceRegistryBuilder().configure().build();

				// Create the MetadataSources
				MetadataSources sources = new MetadataSources(registry);

				// Create the Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		
		//create a Session interface ref for all the transaction
		Session session=sessionFactory.openSession();
		
		//Starting the transaction for DB operations
		session.beginTransaction();		
		
		//Asking the HB to persist these objects in DB
		// save() will fire Insert query
		session.save(user1);
		session.save(user2);
		session.save(user3);
		
		// Retrieving the data - Difference between get and load
		H2Emp h2Emp=(H2Emp)session.load(H2Emp.class, 1);
		System.out.println(h2Emp.getEmpId() + " - " + h2Emp.getEmpName() +" - "+ h2Emp.getOfficeAddress().getEmpCity());
		
		session.getTransaction().commit();
		session.close();			
	}
}

