package com.luv2code.hibernate.demo;

import java.lang.module.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;


public class ReadStudentDemo {

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
			Student tempStudent = new Student("Dilip","dadiya","dadiyame@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving student..");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
			//New code
			
			//find out student's i: primary key
			
			System.out.println("Saved student.Generated id: "+tempStudent.getId());
			
			//get a new session and start transaction
			session = factory.getCurrentSesssion();
			session.beginTransaction();
			
			//retrieve student based on id:primary key
			System.out.println("\Getting student with id:" + tempStudent.getId());
			
			Student myStudent = session.get(Student.class,tempStudent.getId());
			
			System.out.println("Get complete!"+ myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
