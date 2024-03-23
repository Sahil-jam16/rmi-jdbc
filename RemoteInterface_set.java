import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    void createCustomer(String firstName, String lastName, String email, String phoneNumber, String address) throws RemoteException;
    String readCustomer(int customerId) throws RemoteException;
    void updateCustomer(int customerId, String newAddress) throws RemoteException;
    void deleteCustomer(int customerId) throws RemoteException;
}
