package com.learn.hibernate.entities;

import jakarta.persistence.*;

@Entity
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Constructors
    public Certificate() {}

    public Certificate(String courseName) {
        this.courseName = courseName;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    @Override
    public String toString() {
        return "Certificate{id=" + id + ", courseName='" + courseName + "'}";
    }
}
