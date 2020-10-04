package com.luv2code.hibernate.demo;

import java.lang.module.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// `create sessionfactory
		SessionFactory factory = new Configuration().
				                 configure("hibernate.cfg.xml").
				                 addAnnotatedClass(Student.class).
				                 buildSessionFactory();
				
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("Creating new student object....");
			Student tempStudent1 = new Student("Deepak","Sarang","deepak@gmail.com");
			Student tempStudent2 = new Student("Manoj","Sarangmath","Manoj@gmail.com");
			Student tempStudent3 = new Student("Mittu","Sarangmath","Mittu@gmail.com");
			
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving student..");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}finally {
			factory.close();
		}

	}

}
