package NamedQueryExample;


import com.learn.hibernate.entities.Student;
import com.revisehiber.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


	public class NamedQueryExample {
		public static void main(String[] args) {
			// Get Hibernate session
			Session session = HibernateUtil.getSessionFactory().openSession();

			// Use the named query "Student.findByCity"
			Query<Student> query = session.createNamedQuery("Student.findByCity", Student.class);
			query.setParameter("city", "Pune");

			// Get the result
			List<Student> students = query.getResultList();

			// Print the students
			System.out.println("🎓 Students from Mumbai:");
			for (Student s : students) {
				System.out.println(s);
			}

			session.close();
		}
	}


