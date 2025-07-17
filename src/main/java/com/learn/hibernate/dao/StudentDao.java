package com.learn.hibernate.dao;

import com.learn.hibernate.entities.Student;

import java.util.List;

public interface StudentDao {
    void saveStudent(Student student);
    Student getStudent(int id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);
}
