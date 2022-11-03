import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {
	private Client() {}
	
	public static void main(String[] args) {
		String host = (args.length < 1)? null : args[0];
	
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			IAnimal obj = (IAnimal) registry.lookup("Animal");
			System.out.println(obj);
			String response = obj.afficherName();
			System.out.println("Response: " + response);
			//obj.printHello();
			String response2 = obj.afficherNameAndOwner();
			System.out.println("Response2: " + response2);
			//recuperer l'etatde l'animal
			String response3=obj.modifierDossier("nouveau etat de l'animal");
			System.out.println("Response3: " + response3);
			//consulter espece
			
			String response4=obj.consulterEspece();
			System.out.println("Response4: " + response4);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
