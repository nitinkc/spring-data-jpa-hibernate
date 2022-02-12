package com.learningJPA.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
		private static SessionFactory sessionFactory = createSessionFactory();

		private static SessionFactory createSessionFactory() {
			StandardServiceRegistry registry = null;
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

		public static Session createSession() {
			return sessionFactory.openSession();
		}
}
