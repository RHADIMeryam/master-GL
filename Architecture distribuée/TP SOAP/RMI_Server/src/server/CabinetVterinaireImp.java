package server;

import common.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



public class CabinetVterinaireImp extends UnicastRemoteObject implements ICabinetVeterinaire {

	// on declare et on remmplis la liste des animaux
	ArrayList<AnimalImp> listAnim = new ArrayList<AnimalImp>();
	
	
	//=> ces truc on les fait au niveau du server
    /*IAnimal chien= new AnimalImp();
	IAnimal chat= new AnimalImp();
	IAnimal sourie= new AnimalImp();
	IAnimal lapin= new AnimalImp();*/
	
	


	
	
	protected CabinetVterinaireImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//ici on fait juste une methode simple qui sert a faire le recherche d'un animal par nom dans la liste, 
//si on le trouve on dit qu'on a trouve l'objet sionon on dit qu'on a pa le trouver
	
	
	@Override
	public IAnimal rechercherAnimal(String nameAnim) throws RemoteException {
		// TODO Auto-generated method stub
		for (AnimalImp ia : listAnim) {
			if(ia.getName()==nameAnim) System.out.println("Objet trouve : "+ nameAnim);
			else  System.out.println("Objet: "+ nameAnim+" est non trouve : ");
		}
		return null;
	}

}
