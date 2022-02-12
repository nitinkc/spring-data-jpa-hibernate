package com.learningJPA.hibernate.singleTable;

import com.learningJPA.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Z1TesterStudent {

	public static void main(String[] args) {
		StudentHibernate student1=new StudentHibernate();
		student1.setId(101);
		student1.setName("Nitin");
		
		StudentHibernate student2=new StudentHibernate();
		student2.setId(102);
		student2.setName("Sangram");

		SessionFactory sessionFactory = getSessionFactory();

		//create a Session interface ref for all the transaction
		Session session=sessionFactory.openSession();

		//Starting the transaction for DB operations
		session.beginTransaction();

		//Asking the HB to persist these objects in DB
		// save() will fire Insert query
		session.save(student1);
		session.save(student2);

		//Commit the data before saving
		session.getTransaction().commit();


		// Fetching the data from the database (BEFORE COMMITTING)
		StudentHibernate student=(StudentHibernate)session.get(StudentHibernate.class, 2);
		System.out.println("User name is : "+student.getName());


		//Finish the session
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
		session.close();
	}

	private static SessionFactory getSessionFactory() {
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
		return sessionFactory;
	}
}
