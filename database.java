package org.example;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;


public class database extends UnicastRemoteObject implements remote {
    database() throws RemoteException
    {
        super();
    }
    static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USERNAME = "yamuna";
    static final String PASSWORD = "queen2004";
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    public void connect() throws  RemoteException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
            System.out.println("Database connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void create(String username, String password) throws  RemoteException {
        try {
            connect();
            statement = connection.createStatement();
            String sql = "INSERT INTO users3 (username, password) VALUES ('" + username + "', '" + password + "')";
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0)
                System.out.println("User created successfully.");
            else
                System.out.println("User creation failed.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    // Read operation
    public void read() throws  RemoteException {
        try {
            connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users3");
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username") + ", Password: " + resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    public void update( String username, String password) throws  RemoteException {
        try {
            connect();
            statement = connection.createStatement();
            String sql = "UPDATE users3 SET password='" + password + "' WHERE username=" + username;
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0)
                System.out.println("User updated successfully.");
            else
                System.out.println("User update failed.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }
    public  void delete(String username) throws  RemoteException {
        try {
            connect();
            statement = connection.createStatement();
            String sql = "DELETE FROM users3 WHERE username='" + username +"'" ;
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0)
                System.out.println("User deleted successfully.");
            else
                System.out.println("User deletion failed.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
