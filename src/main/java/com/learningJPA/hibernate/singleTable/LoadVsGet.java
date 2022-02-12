package com.learningJPA.hibernate.singleTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class LoadVsGet {

	/**
	 * 1. Load method Throws Exception orgghibernate.ObjectNotFoundException
	 *    if the Id is not found. Get methods returns null
	 * 
	 * 2. Load method returns a Proxy by default and DB won't hit until proxy is first invoked
	 *    while get method hits the DB everytime
	 *    
	 * 3. If sure that the id exists, use Load else use get   */
	public static void main(String[] args) {
		
		Plant plant=new Plant();
		plant.setPName("SunFlower");

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
		
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();

		//session.save(plant);
		
		//select * from Plant where id 1;
		//Plant plant2=(Plant)session.load(Plant.class,1);
		
		
		Plant plant2=(Plant)session.load(Plant.class,1);
		System.out.println("Name of plant : "+plant2.getPName());
		
		session.getTransaction().commit();
		session.close();
	}

}
