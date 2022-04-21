package server;

import common.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



public class CabinetVterinaireImp extends UnicastRemoteObject implements ICabinetVeterinaire {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// on declare et on remmplis la liste des animaux
	private ArrayList<AnimalImp> listAnim = new ArrayList<AnimalImp>();
	private ArrayList<IclientVeter> listClients= new ArrayList<IclientVeter>() ;
	
	//=> ces truc on les fait au niveau du server
    /*IAnimal chien= new AnimalImp();
	IAnimal chat= new AnimalImp();
	IAnimal sourie= new AnimalImp();
	IAnimal lapin= new AnimalImp();*/
	
	
   public CabinetVterinaireImp() throws RemoteException {
		super();
		
		// TODO Auto-generated constructor stub
	}

	
  public CabinetVterinaireImp(ArrayList<AnimalImp> listAnim) throws RemoteException {

		this.listAnim = listAnim;
	}


//ici on fait juste une methode simple qui sert a faire le recherche d'un animal par nom dans la liste, 
//si on le trouve on dit qu'on a trouve l'objet sionon on dit qu'on a pa le trouver
	
	
	@Override
	public AnimalImp rechercherAnimal(String nameAnim) throws RemoteException {
		// TODO Auto-generated method stub
		for (AnimalImp ia : this.listAnim) {
			String name=ia.getName();
			//System.out.println(ia.getName());
			
			if(name.equals(nameAnim)) {
				System.out.println("Objet trouve : "+ nameAnim);
				
				return ia;
			}
			else  System.out.println("Objet: "+ nameAnim+" est non trouve ");
			
		}
		
		return null;
	}




	@Override
	public IAnimal ajouterPatient(String name, String owner, String race) throws RemoteException {
		// TODO Auto-generated method stub
		 AnimalImp anim= new AnimalImp(name,owner,race);
		 listAnim.add(anim);
		 return anim;
	}

     
	@Override
	public String alerteFct() throws RemoteException {
		int i=listClients.size();
		System.out.println("Debut d'alerte");
		IclientVeter client=listClients.get(0);
         switch(i) {
         case 2: 
        	   client.notif(i);
               return "On a arrive a 2 clients"; 
         case 100:
        	 client.notif(i);
        	 return "On a arrive a 100 clients" ; 
         case 500:
        	 client.notif(i);
        	 return "On a arrive a 500 clients"; 
         case 1000:
        	 return "On a arrive a 1000 clients"; 
         default :
        	 System.out.println(" "); 
         }
		/*for(IclientVeter client: listClients) {
			client.notif(cmp);
		}*/
		return "la liste des clients "+ listClients.size() + " on ete notife";
		
	}
   @Override
   public void ajouterClient(IclientVeter client)throws RemoteException  {
    listClients.add(client);   
   }

}
