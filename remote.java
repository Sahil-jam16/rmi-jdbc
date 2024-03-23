package org.example;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface remote extends Remote {
    public void update( String username, String password) throws RemoteException;
    public void delete( String username) throws RemoteException;
    public void create( String username, String password) throws RemoteException;
    public void read( ) throws RemoteException;

}

public interface remote extends Remote{

    public void fun1(int n) throws RemoteException;

}