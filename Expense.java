package com.expensetracker.model;

import java.sql.Date;

public class Expense {
    private int expenseId;
    private String category;
    private double amount;
    private Date expenseDate;
    private String description;

    public Expense() {}

    public Expense(int expenseId, String category, double amount, Date expenseDate, String description) {
        this.expenseId = expenseId;
        this.category = category;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.description = description;
    }

    public Expense(String category, double amount, Date expenseDate, String description) {
        this.category = category;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.description = description;
    }

    public int getExpenseId() { return expenseId; }
    public void setExpenseId(int expenseId) { this.expenseId = expenseId; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getExpenseDate() { return expenseDate; }
    public void setExpenseDate(Date expenseDate) { this.expenseDate = expenseDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return String.format("%-5d %-12s ₹%-10.2f %-12s %-30s",
                expenseId, category, amount, expenseDate, description == null ? "" : description);
    }
}
