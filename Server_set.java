import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteService", new RemoteServerImpl());
            System.out.println("Server is running...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
