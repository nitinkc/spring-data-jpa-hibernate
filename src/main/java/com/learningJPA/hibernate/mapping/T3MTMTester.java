package com.learningJPA.hibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class T3MTMTester {

	public static void main(String[] args) {
		/* Both the participating tables has Alphanumeric Primary keys 
		 * Thus no @GeneratedValues annotation is used in either table
		 * */

		/* Adding Data into the individual Objects */
		M3ComputerLab lab1 = new M3ComputerLab();
		M3ComputerLab lab2 = new M3ComputerLab();
		M3ComputerLab lab3 = new M3ComputerLab();
		M3ComputerLab lab4 = new M3ComputerLab();
		M3ComputerLab lab5 = new M3ComputerLab();

		M3Student student1 = new M3Student();
		M3Student student2 = new M3Student();
		M3Student student3 = new M3Student();

		lab1.setComputerId("M60Q-4T35");
		lab1.setNetworkId("192.156.243.63");

		lab2.setComputerId("M60Q-4T36");
		lab2.setNetworkId("193.233.234.12");

		lab3.setComputerId("M60Q-4T37");
		lab3.setNetworkId("191.11.114.11");

		lab4.setComputerId("M60Q-4T38");
		lab4.setNetworkId("193.234.56.45");

		lab5.setComputerId("M60Q-4T39");
		lab5.setNetworkId("123.111.114.56");

		student1.setEnrollId("GS123");
		student1.setName("Billoo");

		student2.setEnrollId("GS124");
		student2.setName("Billoo");

		student3.setEnrollId("GS125");
		student3.setName("Billoo");

		List<M3ComputerLab> compLab1 = new ArrayList<M3ComputerLab>();
		List<M3ComputerLab> compLab2 = new ArrayList<M3ComputerLab>();

		compLab1.add(lab1);
		compLab1.add(lab2);
		compLab1.add(lab3);

		compLab2.add(lab4);
		compLab2.add(lab5);

		List<M3Student> stud1 = new ArrayList<M3Student>();
		List<M3Student> stud2 = new ArrayList<M3Student>();

		stud1.add(student1);
		stud1.add(student2);

		stud2.add(student3);
		stud2.add(student2);

		lab1.setStudentAssigned(stud1);
		lab2.setStudentAssigned(stud1);
		lab3.setStudentAssigned(stud1);
		lab4.setStudentAssigned(stud2);
		lab5.setStudentAssigned(stud2);

		student1.setAssignedToComp(compLab2);
		student2.setAssignedToComp(compLab2);
		student3.setAssignedToComp(compLab1);

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
		
		session.save(lab1);
		session.save(lab2);
		session.save(lab3);
		session.save(lab4);
		session.save(lab5);
		
		session.save(student1);
		session.save(student2);
		session.save(student3);

		session.getTransaction().commit();
		session.close();
	}
}
