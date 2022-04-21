package server;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Server {
	public Server() {
		
	}
	
	/* METHODS */
	public static void main(String[] args) {
		try {
			
			// gestionaire de sécurité
          /* String path = "\\RMI_Client\\src\\client.policy";
			
			System.setProperty( "java.security.policy", path);
			SecurityManager securityManager = new SecurityManager();
        	System.setSecurityManager(securityManager);			
			
			*/
			
			//instancier objet distant

			AnimalImp obj = new AnimalImp("christ","monim", "chat");
			obj.setEspeceAnim(new EspeceAnimal("chatton",10));
			AnimalImp animal1 = new AnimalImp("robin","zayn", "chien");
			AnimalImp animal2 = new AnimalImp("belle","maria", "chien");
			AnimalImp animal3 = new AnimalImp("rosa","david", "chat");
			AnimalImp animal4 = new AnimalImp("anna","gims", "lapin");
			DossierSuiviImpl dossier= new DossierSuiviImpl();
			ArrayList<AnimalImp> listDesAnimaux = new ArrayList<AnimalImp>();
			listDesAnimaux.add(animal4);
			listDesAnimaux.add(animal3);
			listDesAnimaux.add(animal2);
			listDesAnimaux.add(animal1);
			CabinetVterinaireImp cabinet= new CabinetVterinaireImp(listDesAnimaux);
			
			//demarer l'annuaire
			Registry registry = LocateRegistry.createRegistry(1099);
			
			if (registry == null)
				System.err.println("Registry not found on port 1099");
			else {
				registry.bind("Animal", obj);
				registry.bind("dossierSuivi", dossier);
				registry.bind("cabinet", cabinet );
				System.err.println("Server ready");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
