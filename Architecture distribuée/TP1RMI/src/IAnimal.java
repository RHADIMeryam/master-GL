import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IAnimal extends Remote {
	/* METHODS */
String afficherName() throws RemoteException;
String afficherNameAndOwner() throws RemoteException;
String modifierDossier(String ett) throws RemoteException;
String consulterEspece() throws RemoteException;
	
}
