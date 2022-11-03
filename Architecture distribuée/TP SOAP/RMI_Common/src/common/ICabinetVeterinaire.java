package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICabinetVeterinaire extends Remote {
	
 IAnimal rechercherAnimal(String nameAnim) throws RemoteException;
}
