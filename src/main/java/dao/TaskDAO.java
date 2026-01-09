package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Task;

public class TaskDAO {
    private String url = "jdbc:sqlite:/home/patrick/task_tracker_java/tasks.db";
    
    public void addTask(Task task) {
        // Code to add task to the database
        String sql = "INSERT INTO tasks(id, name, createdDate, status) VALUES(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getId()); 
            pstmt.setString(2, task.getName());
            pstmt.setString(3, LocalDate.now().toString());
            pstmt.setString(4, "todo");
            pstmt.executeUpdate();
            System.out.println("Task added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }

    public void deleteTask(String taskId) {
        // Code to delete task from the database
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, taskId);
            pstmt.executeUpdate();
            System.out.println("Task deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting task: " + e.getMessage());
        }
    }

    public void updateTaskStatus(String name, String status) {
        // Code to update task status in the database
        String sql = "UPDATE tasks SET status = ? WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            System.out.println("Task status updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating task status: " + e.getMessage());
        }
    }

    public void listTasks() {
        // Code to list all tasks from the database
        String sql = "SELECT * FROM tasks";
        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(sql);) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id") + ", Name: " + rs.getString("name") + ", Created Date: " + rs.getString("createdDate") + ", Status: " + rs.getString("status"));
            }
        } catch (SQLException e) {
            System.out.println("Error listing tasks: " + e.getMessage());
        }
    }
}
