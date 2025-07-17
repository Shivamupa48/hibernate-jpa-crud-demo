# hibernate-jpa-crud-demo
A Java-based project demonstrating Hibernate ORM with JPA for CRUD operations, relationships, validation, named queries, pagination, and sorting using MySQL.


# Hibernate JPA CRUD Demo 🛠️

This project demonstrates how to use **Hibernate ORM with JPA** annotations to perform CRUD operations in a Java application, along with:

- ✅ One-to-Many relationship mapping
- ✅ Hibernate Validator integration
- ✅ Pagination & Sorting using HQL
- ✅ Named Queries with parameters
- ✅ MySQL as the database
- ✅ Maven for dependency management

---

## 💡 Technologies Used

- Java 17+
- Hibernate ORM 6
- Hibernate Validator (JSR 380)
- Jakarta Persistence (JPA)
- MySQL
- Maven

---

## 📦 Features Implemented

- Create & save entities (`Student`, `Certificate`)
- One-to-Many mapping (`Student` → `Certificates`)
- Input validation using annotations like `@NotNull`, `@Min`, `@Size`
- Custom named query: `Student.findByCity`
- Sorting and pagination using HQL queries
- Clean separation of concerns (DAO layer, Entity layer)

---

## 🧪 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/YOUR_USERNAME/hibernate-jpa-crud-demo.git
