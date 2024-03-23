package org.example;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException {
        try{
            remote calculator = new database();
            Registry registry = LocateRegistry.createRegistry(10000);
            registry.rebind("Calculator", calculator);
            System.out.println("Service Stared..!!");
        }catch(Exception a)
        {}
}

