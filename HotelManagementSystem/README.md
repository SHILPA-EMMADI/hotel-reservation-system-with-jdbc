# Hotel Management System

A console-based **Hotel Management System** developed using **Core Java, JDBC, and MySQL**. This project allows hotel staff to manage rooms, guests, reservations, check-in, check-out, and billing operations.

The project was developed as part of my Java backend and JDBC learning journey to gain practical experience in database connectivity, CRUD operations, SQL queries, exception handling, and layered architecture.

---

## Features

- View all hotel rooms
- View available rooms
- Add guest details
- Book a hotel room
- View all reservations
- Search reservation by ID
- Update reservation details
- Cancel reservations
- Check-in guests
- Check-out guests
- Generate room bills
- Store payment details
- Validate user input
- Prevent booking of unavailable rooms
- Use database transactions for important operations

---

## Technologies Used

- **Java 21**
- **Core Java**
- **JDBC**
- **MySQL**
- **MySQL Workbench**
- **IntelliJ IDEA**
- **Git and GitHub**

---

## Concepts Demonstrated

This project demonstrates the following Java and JDBC concepts:

- Object-Oriented Programming
- Classes and Objects
- Encapsulation
- Exception Handling
- Collections
- Input Validation
- JDBC Driver Loading
- Database Connectivity
- `Connection`
- `PreparedStatement`
- `Statement`
- `ResultSet`
- CRUD Operations
- SQL Queries
- Joins
- Transactions
- `commit()`
- `rollback()`
- DAO Pattern
- Layered Architecture

---

## Project Architecture

The project follows a simple layered architecture:

```text
Main Class
    |
    v
Service Layer
    |
    v
DAO Layer
    |
    v
JDBC
    |
    v
MySQL Database
