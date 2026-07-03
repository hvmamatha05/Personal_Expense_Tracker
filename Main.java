package com.expensetracker.main;

import com.expensetracker.dao.ExpenseDAO;
import com.expensetracker.model.Expense;
import com.expensetracker.util.DBConnection;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ExpenseDAO dao = new ExpenseDAO();

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> addExpense();
                case 2 -> viewAllExpenses();
                case 3 -> viewByCategory();
                case 4 -> updateExpense();
                case 5 -> deleteExpense();
                case 6 -> viewTotal();
                case 7 -> viewMonthlyTotal();
                case 0 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 0);

        DBConnection.closeConnection();
        sc.close();
    }

    static void printMenu() {
        System.out.println("\n===== PERSONAL EXPENSE TRACKER =====");
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. View Expenses by Category");
        System.out.println("4. Update Expense");
        System.out.println("5. Delete Expense");
        System.out.println("6. View Total Expense");
        System.out.println("7. View Monthly Total");
        System.out.println("0. Exit");
    }

    static void addExpense() {
        System.out.print("Category: ");
        String category = sc.nextLine();
        double amount = readDouble("Amount: ");
        System.out.print("Date (yyyy-mm-dd): ");
        String dateInput = sc.nextLine().trim();
        Date date=Date.valueOf(dateInput);
        System.out.print("Description: ");
        String desc = sc.nextLine();

        Expense e = new Expense(category, amount, date, desc);
        System.out.println(dao.addExpense(e) ? "Expense added successfully!" : "Failed to add expense.");
    }

    static void viewAllExpenses() {
        List<Expense> list = dao.getAllExpenses();
        printExpenseList(list);
    }

    static void viewByCategory() {
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        printExpenseList(dao.getExpensesByCategory(category));
    }

    static void updateExpense() {
        int id = readInt("Enter Expense ID to update: ");
        System.out.print("New Category: ");
        String category = sc.nextLine();
        double amount = readDouble("New Amount: ");
        System.out.print("New Date (yyyy-mm-dd): ");
        Date date = Date.valueOf(sc.nextLine());
        System.out.print("New Description: ");
        String desc = sc.nextLine();

        Expense e = new Expense(id, category, amount, date, desc);
        System.out.println(dao.updateExpense(e) ? "Expense updated!" : "Update failed. Check the ID.");
    }

    static void deleteExpense() {
        int id = readInt("Enter Expense ID to delete: ");
        System.out.println(dao.deleteExpense(id) ? "Expense deleted!" : "Delete failed. Check the ID.");
    }

    static void viewTotal() {
        System.out.printf("Total Expense: ₹%.2f%n", dao.getTotalExpense());
    }

    static void viewMonthlyTotal() {
        int month = readInt("Enter month (1-12): ");
        int year = readInt("Enter year (e.g. 2026): ");
        System.out.printf("Total for %d/%d: ₹%.2f%n", month, year, dao.getMonthlyTotal(month, year));
    }

    static void printExpenseList(List<Expense> list) {
        if (list.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        System.out.printf("%-5s %-12s %-11s %-12s %-30s%n", "ID", "Category", "Amount", "Date", "Description");
        for (Expense e : list) System.out.println(e);
    }

    static int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.print("Enter a valid amount: ");
            sc.next();
        }
        double val = sc.nextDouble();
        sc.nextLine();
        return val;
    }
}


