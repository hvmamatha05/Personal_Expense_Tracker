
# Personal Expense Tracker

A console-based Java application that helps users manage daily expenses using JDBC and MySQL. This project demonstrates CRUD operations, database connectivity, and object-oriented programming concepts.

## Features

- Add a new expense
- View all expenses
- Search expenses by category
- Update an existing expense
- Delete an expense
- View total expenses
- View monthly expense summary
- Menu-driven console interface

## Technologies Used

- Java
- JDBC
- MySQL
- Eclipse IDE
- MySQL Workbench


## Database

Create a MySQL database named: expense_tracker

Create the required table before running the application.

Update `db.properties` with your MySQL credentials.


_db.properties_
db.url=jdbc:mysql://localhost:3306/expense_tracker
db.user=root
db.password=your_password

## How to Run

1. Clone the repository.
2. Import the project into Eclipse IDE.
3. Add MySQL Connector/J to the project's Build Path.
4. Create the `expense_tracker` database and required table.
5. Update `db.properties`.
6. Run `Main.java`.

## Sample Menu

===== PERSONAL EXPENSE TRACKER =====

1. Add Expense
2. View All Expenses
3. View Expenses by Category
4. Update Expense
5. Delete Expense
6. View Total Expense
7. View Monthly Total
0. Exit
```

## Skills Demonstrated

- Core Java
- Object-Oriented Programming (OOP)
- JDBC
- MySQL
- CRUD Operations
- Exception Handling
- Collections
- File Handling using Properties
- DAO Design Pattern


