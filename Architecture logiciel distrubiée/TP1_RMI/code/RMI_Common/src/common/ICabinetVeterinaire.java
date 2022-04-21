package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICabinetVeterinaire extends Remote {
	
 public IAnimal rechercherAnimal(String nameAnim) throws RemoteException;
 public IAnimal ajouterPatient(String name, String owner, String race) throws RemoteException;
 public String alerteFct() throws RemoteException;
 public void ajouterClient(IclientVeter client) throws RemoteException  ;

 
}
