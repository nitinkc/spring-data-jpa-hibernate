package com.learningJPA.hibernate.singleTable;

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

public class Z2HasASingleTable {
	public static void main(String[] args) {
		
		/* 3 address that are used in the User Class*/
		H1Address address1=new H1Address();
		address1.setPincode(112233);
		address1.setCity("New Delhi");
		
		H1Address address2=new H1Address();
		address2.setPincode(998877);
		address2.setCity("Mumbai");
		
		H1Address address3=new H1Address();
		address3.setPincode(774411);
		address3.setCity("Chennai");
		
		
		H1User user1=new H1User();
		//U_id is automatically set
		user1.setUName("Nitin");
		user1.setUAddress(address1);
		
		H1User user2=new H1User();
		user2.setUName("Sangram");
		user2.setUAddress(address2);
		
		H1User user3=new H1User();
		user3.setUName("Biloo");
		user3.setUAddress(address3);
				
		
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
		
		//Retreiving the data - Difference between get and load
		H1User h1User=(H1User)session.load(H1User.class, 1);
		System.out.println(h1User.getUId() + " - " + h1User.getUName() +" - "+ h1User.getUAddress().getCity());
		
		session.getTransaction().commit();
		session.close();		
		
	}
}

