package com.luv2code.hibernate.demo;

import java.lang.module.Configuration;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;


public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// `create sessionfactory
		SessionFactory factory = new Configuration().
				                 configure("hibernate.cfg.xml").
				                 addAnnotatedClass(Student.class).
				                 buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Students> theStudents = session.createQuery("from Student").getResultList(); 
			
			//display students
			displayStudents(theStudents);
			
			//query students
			List<Students> theStudents = session.createQuery("from Student s where s.lastName = 'Sarang'").getResultList(); 
			
			//display students
			System.out.println("\n\nStudents who have lastName as Sarang");
			displayStudents(theStudents);
			
			//query students with lastName Sarang OR firstName as Deepak
			theStudents = session.createQuery("from Student s where" 
					                 + "s.lastName = 'Sarang' OR firstName = 'Deepak'").getResultList();
			
			//display 
			System.out.println("\n\nStudents with firstName Deepak OR lastName Sarang.. ");
			displayStudents(theStudents);
			
			//query LIKE clause for email @gmail.com
		    students = session.createQuery("from Student s where "
		    		      + "s.email LIKE '@gmail.com'").getResultList();
		    
			//display students
		    System.out.println("\n\nStudents with email @gmail.com.. ");
		    displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Students> theStudents) {
		for(Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}

}
