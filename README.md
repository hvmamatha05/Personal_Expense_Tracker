
# Personal Expense Tracker

## Overview
Personal Expense Tracker is a Java console-based application developed using JDBC and MySQL. It helps users manage daily expenses by allowing them to add, view, update, and delete expense records. The project demonstrates CRUD operations, database connectivity, and object-oriented programming concepts.

## Features
- Add new expenses
- View all expenses
- View expenses by category
- Update existing expenses
- Delete expenses
- Calculate total expenses
- Store data securely in MySQL database
- Menu-driven console application

## Technologies Used
- Java
- JDBC
- MySQL
- Eclipse IDE
- MySQL Connector/J
- Git & GitHub

## Project Structure
```
personal_expense_tracker/
│
├── src/
│   ├── com.personalexpensetracker.dao/
│   ├── com.personalexpensetracker.main/
│   ├── com.personalexpensetracker.model/
│   └── com.personalexpensetracker.util/
│
├── database.sql
├── db.properties
├── .classpath
└── .project
```

## Database
Create a MySQL database named: personal_expense_tracker


Run the SQL script provided in: database.sql

Update the database credentials in: db.properties

Example:

url=jdbc:mysql://localhost:3306/expense_tracker
username=root
password=your_password


## How to Run

1. Clone the repository.

```
git clone https://github.com/your-username/personal_expense_tracker.git
```

2. Import the project into Eclipse.

3. Add MySQL Connector/J to the project build path.

4. Create the database using the SQL script.

5. Update `db.properties` with your MySQL credentials.

6. Run `Main.java`.

## Sample Menu

```
===== Personal Expense Tracker =====

1. Add Expense
2. View All Expenses
3. View Expense by Category
4. Update Expense
5. Delete Expense
6. View Total Expense
0. Exit
```

## Concepts Covered
- Object-Oriented Programming (OOP)
- JDBC Connectivity
- CRUD Operations
- MySQL Database
- DAO Design Pattern
- Exception Handling
- Collections
- File Handling using Properties File

## Future Enhancements
- User Login & Registration
- Monthly Expense Reports
- Budget Management
- Export Reports to PDF or Excel
- GUI using JavaFX or Swing
- Spring Boot REST API

