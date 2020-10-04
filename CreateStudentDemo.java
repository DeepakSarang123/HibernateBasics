package com.luv2code.hibernate.demo;

import java.lang.module.Configuration;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;


public class CreateStudentDemo {

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
			Student tempStudent = new Student("Deepak","Sarang","deepak@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving student..");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}finally {
			factory.close();
		}

	}

}
