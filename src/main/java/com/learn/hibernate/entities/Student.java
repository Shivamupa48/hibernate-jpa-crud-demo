package com.learn.hibernate.entities;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NamedQuery(
	    name = "Student.findByCity",
	    query = "FROM Student s WHERE s.city = :city"
	)
@Entity
public class Student {

    @Id
    @Min(value = 1, message = "ID must be greater than 0")
    private int id;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private int age;

    @NotBlank(message = "City must not be blank")
    private String city;

    // ✅ One-to-Many relationship to Certificate
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Certificate> certificates = new ArrayList<>();

    // Constructors
    public Student() {}

    public Student(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + ", city='" + city + "'}";
    }
}
