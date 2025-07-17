package com.learn.hibernate.hibernate_crud_demo;

import com.learn.hibernate.dao.StudentDao;
import com.learn.hibernate.dao.StudentDaoImpl;
import com.learn.hibernate.entities.Student;
import com.learn.hibernate.entities.Certificate;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Arrays;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        StudentDao studentDao = new StudentDaoImpl();

        // ✅ Create a student
        Student student = new Student(111, "atul", 20, "Mumbai");

        // ✅ Create certificates
        Certificate cert1 = new Certificate("Spring Boot");
        Certificate cert2 = new Certificate("Microservices");

        // ✅ Link certificates to student
        cert1.setStudent(student);
        cert2.setStudent(student);
        student.setCertificates(Arrays.asList(cert1, cert2));

        // ✅ Step 1: Setup validation
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // ✅ Step 2: Validate the student object
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        // ✅ Step 3: Handle validation results
        if (!violations.isEmpty()) {
            System.out.println("❌ Validation errors found:");
            for (ConstraintViolation<Student> v : violations) {
                System.out.println("- " + v.getPropertyPath() + ": " + v.getMessage());
            }
        } else {
            // ✅ Step 4: Save student if valid
            studentDao.saveStudent(student);
            System.out.println("✅ Student with certificates saved!");
        }
    }
}
