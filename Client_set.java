import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RemoteInterface remote = (RemoteInterface) registry.lookup("RemoteService");

            // Use methods from remote interface
            remote.createCustomer("John", "Doe", "john@example.com", "1234567890", "123 Main St");
            System.out.println("Customer created.");

            String customerInfo = remote.readCustomer(1);
            System.out.println("Customer Information:\n" + customerInfo);

            remote.updateCustomer(1, "456 Elm St");
            System.out.println("Customer address updated.");

            remote.deleteCustomer(1);
            System.out.println("Customer deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
