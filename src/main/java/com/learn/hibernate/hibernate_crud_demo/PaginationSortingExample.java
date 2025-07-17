package com.learn.hibernate.hibernate_crud_demo;

import com.learn.hibernate.entities.Student;
import com.revisehiber.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class PaginationSortingExample {
	
	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// HQL query with order by sorting students by name (ascending)
		
		String hql = "From Student s ORDER BY s.name ASC";
		
		Query<Student> query = session.createQuery(hql, Student.class);
		
		// set pagination - fetch only 3 records starting from index 0
		
		query.setFirstResult(0);
		query.setMaxResults(3);
		
		List<Student> students = query.getResultList();
		
		System.out.println(" Page 1 - Sorted Students (max 3):");
		for(Student student : students) {
			System.out.println(student);
		}
		session.close();
	}

}
