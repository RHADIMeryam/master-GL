package common;

   import java.rmi.Remote;
   import java.rmi.RemoteException;


   public interface IAnimal extends Remote {
	/* METHODS */
	   public String getName() throws RemoteException;
	   public void setName(String name) throws RemoteException;
	   public String getOwner() throws RemoteException;
	   public void setOwner(String owner) throws RemoteException;
	   public void affichage()throws RemoteException;
	   public String nomComplet()throws RemoteException;
	   //String modifierDossier(String ett) throws RemoteException;
	   String consulterEspece() throws RemoteException;
	
}
