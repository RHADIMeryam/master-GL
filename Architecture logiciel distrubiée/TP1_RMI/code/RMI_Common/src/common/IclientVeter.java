package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IclientVeter extends Remote {
	
	
	public String getClient() throws RemoteException;
	public void setClient(String client)throws RemoteException;
	public void notif(int nbr) throws RemoteException;

}
