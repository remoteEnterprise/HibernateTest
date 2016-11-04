package test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			Student s = new Student("Leonardo","Leitao","ldal19@outlook.com");
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
