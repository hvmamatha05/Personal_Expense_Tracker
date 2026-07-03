
package com.expensetracker.dao;

import com.expensetracker.model.Expense;
import com.expensetracker.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    // CREATE
    public boolean addExpense(Expense expense) {
        String sql = "INSERT INTO expenses (category, amount, expense_date, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, expense.getCategory());
            ps.setDouble(2, expense.getAmount());
            ps.setDate(3, expense.getExpenseDate());
            ps.setString(4, expense.getDescription());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding expense: " + e.getMessage());
            return false;
        }
    }

    // READ ALL
    public List<Expense> getAllExpenses() {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses ORDER BY expense_date DESC";
        try (Statement st = DBConnection.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching expenses: " + e.getMessage());
        }
        return list;
    }

    // READ BY CATEGORY
    public List<Expense> getExpensesByCategory(String category) {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses WHERE category = ? ORDER BY expense_date DESC";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, category);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching expenses by category: " + e.getMessage());
        }
        return list;
    }

    // UPDATE
    public boolean updateExpense(Expense expense) {
        String sql = "UPDATE expenses SET category=?, amount=?, expense_date=?, description=? WHERE expense_id=?";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, expense.getCategory());
            ps.setDouble(2, expense.getAmount());
            ps.setDate(3, expense.getExpenseDate());
            ps.setString(4, expense.getDescription());
            ps.setInt(5, expense.getExpenseId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating expense: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean deleteExpense(int expenseId) {
        String sql = "DELETE FROM expenses WHERE expense_id=?";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, expenseId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting expense: " + e.getMessage());
            return false;
        }
    }

    // TOTAL
    public double getTotalExpense() {
        String sql = "SELECT SUM(amount) AS total FROM expenses";
        try (Statement st = DBConnection.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) return rs.getDouble("total");
        } catch (SQLException e) {
            System.out.println("Error calculating total: " + e.getMessage());
        }
        return 0.0;
    }

    // MONTHLY TOTAL
    public double getMonthlyTotal(int month, int year) {
        String sql = "SELECT SUM(amount) AS total FROM expenses WHERE MONTH(expense_date)=? AND YEAR(expense_date)=?";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, month);
            ps.setInt(2, year);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.out.println("Error calculating monthly total: " + e.getMessage());
        }
        return 0.0;
    }

    private Expense mapRow(ResultSet rs) throws SQLException {
        return new Expense(
                rs.getInt("expense_id"),
                rs.getString("category"),
                rs.getDouble("amount"),
                rs.getDate("expense_date"),
                rs.getString("description")
        );
    }
}
