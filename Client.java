package org.example;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args){
        try{
            Registry registry = LocateRegistry.getRegistry("192.168.29.61", 10000);
            remote calculator = (remote) registry.lookup("Calculator");
            calculator.create("abarna","hihello");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
