package com.learn.hibernate.hibernate_crud_demo;
import com.learn.hibernate.entities.Certificate;

import com.learn.hibernate.entities.Student;
import com.revisehiber.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HqlExample {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // HQL: Fetch all students
        String hql = "FROM Student";  // Equivalent to: SELECT * FROM Student
        Query<Student> query = session.createQuery(hql, Student.class);
        List<Student> students = query.getResultList();

        System.out.println("📘 All Students:");
        for (Student student : students) {
            System.out.println(student);
        }

        // HQL: Fetch students from a specific city
        String hql2 = "FROM Student s WHERE s.city = :cityName";
        Query<Student> cityQuery = session.createQuery(hql2, Student.class);
        cityQuery.setParameter("cityName", "Delhi");
        List<Student> delhiStudents = cityQuery.getResultList();

        System.out.println("\n🏙️ Students from Delhi:");
        for (Student s : delhiStudents) {
            System.out.println(s);
        }
        
        // Fetch all certificates with their students
        String hql1 = "SELECT c FROM Certificate c JOIN FETCH c.student";
        Query<Certificate> certquery = session.createQuery(hql1, Certificate.class);
        List<Certificate> certificates = certquery.getResultList();

        for (Certificate cert : certificates) {
            System.out.println("📜 Certificate: " + cert.getCourseName());
            System.out.println("👨‍🎓 Student: " + cert.getStudent());
            System.out.println("------");
        }


        session.close();
    }
}
