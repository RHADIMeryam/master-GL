package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IdossierSuivi extends Remote {
	public void setEtatAnimal(String etatAnimal) throws RemoteException;
	public String getEtatAnimal() throws RemoteException;
	

}
