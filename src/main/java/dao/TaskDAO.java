package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Task;

public class TaskDAO {
    private String url = "jdbc:sqlite:tasks.db";
    public void addTask(Task task) {
        // Code to add task to the database
        String sql = "INSERT INTO tasks(name, createdDate, status) VALUES(?,?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getName());
            pstmt.setString(2, LocalDate.now().toString());
            pstmt.setString(3, task.getStatus());
            pstmt.executeUpdate();
            System.out.println("Task added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }

    public void deleteTask(int taskId) {
        // Code to delete task from the database
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, taskId);
            pstmt.executeUpdate();
            System.out.println("Task deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting task: " + e.getMessage());
        }
    }

    public void updateTaskStatus(int taskId, String status) {
        // Code to update task status in the database
        String sql = "UPDATE tasks SET status = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, taskId);
            pstmt.executeUpdate();
            System.out.println("Task status updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating task status: " + e.getMessage());
        }
    }
}
