package com.luv2code.hibernate.demo;

import java.lang.module.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;


public class UpdateStudentdemo {

	public static void main(String[] args) {
		
		// `create sessionfactory
		SessionFactory factory = new Configuration().
				                 configure("hibernate.cfg.xml").
				                 addAnnotatedClass(Student.class).
				                 buildSessionFactory();
		
		
		
		try {
		
            int studentId = 1;
           
			
			
			//get a new session and start transaction
			session = factory.getCurrentSesssion();
			session.beginTransaction();
			
			//retrieve student based on id:primary key
			System.out.println("\Getting student with id:" + studentId);
			
			Student myStudent = session.get(Student.class,studentId);
			
			System.out.println("Updating student..");
			myStudent.setFirstName("HotDeepak");

			//commit transaction
			session.getTransaction().commit();
			
			
			
			
			
			//NEW code
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("Updating email for all students..");
			session.createQuery("update Student set email='@google.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			
			
			
		}finally {
			factory.close();
		}

	}

}
