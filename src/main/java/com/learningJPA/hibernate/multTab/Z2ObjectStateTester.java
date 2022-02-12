package com.learningJPA.hibernate.multTab;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Z2ObjectStateTester {
	public static void main(String[] args) {

		Apple apple=new Apple();
		//apple is transient now
		apple.setAppleId(101);
		apple.setAppleLocation("Kashmir");

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
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(apple);
		
		session.getTransaction().commit();
		//Detached object
		session.close();

	}
}
