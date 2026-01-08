package com.klu.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class App {
	public static void main(String[] args) {
		//Load Configuration and create a SessionFactory
		SessionFactory factory=new Configuration()
				.configure().buildSessionFactory();
		//Open session
		Session session = factory.openSession();
		//Begin Transaction
		Transaction tx=session.beginTransaction();
		//create the table/object
		Student s=new Student("Ruthwika");
		//Save the data/object
		session.save(s);
		//commit
		tx.commit();
		//close the connection
		session.close();
		factory.close();
		System.out.println("Student data inserted Successfully");
	}
}
