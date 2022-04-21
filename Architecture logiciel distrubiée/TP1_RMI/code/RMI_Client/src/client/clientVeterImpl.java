package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.*;

public class clientVeterImpl extends UnicastRemoteObject implements IclientVeter{
    
	private String client;
	protected clientVeterImpl(String client) throws RemoteException {
		super();
		this.client=client;
	}
	
	@Override
	public String getClient() {
		return client;
	}

    @Override
	public void setClient(String client) {
		this.client = client;
	}


	@Override
	public void notif(int nbr) {
	
			System.out.println("Notification : nombre de clients  " +nbr);
		
	}

	

	
	

}
