package org.example;

import java.sql.*;

public class Main {

    // JDBC URL, username, and password of Oracle database server
    static final String JDBC_URL = "jdbc:oracle:thin:@10.1.67.153:1522:orclNew";
    static final String USERNAME = "msc21pc22";
    static final String PASSWORD = "msc21pc22";

    // JDBC variables for connection, statement, and result set
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;

    // Method to establish database connection
    public static void connect() {
        try {
            // Registering the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establishing connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close database connection
    public static void close() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
            System.out.println("Database connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create operation
    public static void create(String username, String password) {
        try {
            connect();
            System.out.println("Hello");
            statement = connection.createStatement();
            String sql = "INSERT INTO users3 (username, password) VALUES ('" + username + "', '" + password + "')";
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Hello1");

            if (rowsAffected > 0)
                System.out.println("User created successfully.");
            else
                System.out.println("User creation failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    // Read operation
    public static void read() {
        try {
            connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users3");
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username") + ", Password: " + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    // Update operation
    public static void update( String username, String password) {
        try {
            connect();
            statement = connection.createStatement();
            String sql = "UPDATE users3 SET password='" + password + "' WHERE username=" + username;
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0)
                System.out.println("User updated successfully.");
            else
                System.out.println("User update failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    // Delete operation
    public static void delete(String username) {
        try {
            connect();
            statement = connection.createStatement();
            String sql = "DELETE FROM users3 WHERE username='" + username +"'" ;
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0)
                System.out.println("User deleted successfully.");
            else
                System.out.println("User deletion failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public static void main(String[] args) {
        // Example usage
        create("satheesh", "sat@example.com");
        read();
        //update("John Doe", "jane@example.com");
        //read();
        delete("satheesh");
        read();
    }
}