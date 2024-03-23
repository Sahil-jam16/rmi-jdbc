import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoteServerImpl extends UnicastRemoteObject implements RemoteInterface {
    // JDBC connection parameters
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_USER = "renu";
    private static final String DB_PASSWORD = "password1";

    protected RemoteServerImpl() throws RemoteException {
        super();
    }

    @Override
    public void createCustomer(String firstName, String lastName, String email, String phoneNumber, String address) throws RemoteException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO customers (customer_id, first_name, last_name, email, phone_number, address) VALUES (customer_seq.nextval, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setString(4, phoneNumber);
                statement.setString(5, address);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readCustomer(int customerId) throws RemoteException {
        String customerInfo = "";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM customers WHERE customer_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, customerId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("customer_id");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        String email = resultSet.getString("email");
                        String phoneNumber = resultSet.getString("phone_number");
                        String address = resultSet.getString("address");
                        customerInfo = "Customer ID: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nAddress: " + address;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerInfo;
    }

    @Override
    public void updateCustomer(int customerId, String newAddress) throws RemoteException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE customers SET address = ? WHERE customer_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, newAddress);
                statement.setInt(2, customerId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int customerId) throws RemoteException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "DELETE FROM customers WHERE customer_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, customerId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
