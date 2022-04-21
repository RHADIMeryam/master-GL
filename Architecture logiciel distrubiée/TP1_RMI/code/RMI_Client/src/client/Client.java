package client;
import common.*;
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
			// gestionaire de sécurité

			    /*String path = "\\RMI_Server\\src\\server.policy";
				
				System.setProperty( "java.security.policy", path);
				SecurityManager securityManager = new SecurityManager();
	        	System.setSecurityManager(securityManager);	*/		
				 
			IAnimal obj = (IAnimal) registry.lookup("Animal");
			IdossierSuivi stub=(IdossierSuivi) registry.lookup("dossierSuivi");
			ICabinetVeterinaire cabinet = (ICabinetVeterinaire) registry.lookup("cabinet");
			IclientVeter clientVeter = new clientVeterImpl("jack");
			IclientVeter clientVeter2 = new clientVeterImpl("zakaria");
			IclientVeter clientVeter3 = new clientVeterImpl("meryam");

			cabinet.ajouterClient(clientVeter);
			cabinet.ajouterClient(clientVeter2);
			//cabinet.ajouterClient(clientVeter3);
			
			String response = obj.getName();
			System.out.println("Response1:\n \t le nom de l'animal c'est :" + response);
			
			String response2 = obj.nomComplet();
			System.out.println("Response2: \n \t  le nom complet:  " + response2);
			
			stub.setEtatAnimal("L'etat de l'animal est mise à jours.");
			String response3 =stub.getEtatAnimal();
			System.out.println("Response3:  " + response3);
			//consulter espece
			String response4=obj.consulterEspece();
			System.out.println("Response4: " + response4);
			//rechercher un animal dans le cabinet
			String response5= cabinet.rechercherAnimal("anna").getName();
            

			if(response5!=null) {
			System.out.println("Response5: l'animal recherché est trouvé, il s'appelle " + response5);
			}
			else 	System.out.println("Response5: l'animal "+ response5 +" n'est pas trouvé dans la liste du cabinet");
           
            cabinet.ajouterPatient("tom","zakaria","chat")	;
            cabinet.ajouterPatient("jerry","jack","souris");
           // cabinet.ajouterPatient("charo","khan","elephant");
            String response7 =stub.getEtatAnimal();
			System.out.println(cabinet.alerteFct());
            
			String response6= cabinet.rechercherAnimal("jerry").getName();
			System.out.println("Response6: l'animal recherché est trouvé, il s'appelle " + response6);


		

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
