package com.learningJPA.hibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class T1OTOTester {
	public static void main(String[] args) {
		
		M1SSNCard card = new M1SSNCard();
		card.setSsn(123456789);
		card.setIssuedBy("Ohio");
		
		M1Resident person = new M1Resident();
		person.setName("Nitin");
		person.setSsn(card);

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

		session.save(card);
		session.save(person);

		session.getTransaction().commit();
		session.close();
	}
}
