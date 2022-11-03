package server;
import common.*;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class AnimalImp extends UnicastRemoteObject implements IAnimal {
	
	private String name;
	private String owner;
	private String espece;
	private String race;
	
	//protected	DossierDeSuivi dossierSuivi = new DossierDeSuivi();
	protected EspeceAnimal especeAnim =new EspeceAnimal();
	
	protected AnimalImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getName()throws RemoteException{
		name="chat";
		return name;
	}
	
	

	/*@Override
	public String modifierDossier(String etatAnim) throws RemoteException {
			// TODO Auto-generated method stub
		String etat=dossierSuivi.modifierEtat(etatAnim);
			return etat;
	}*/

	@Override
	public String consulterEspece() throws RemoteException {
		// TODO Auto-generated method stub
		String name=especeAnim.getName();
		float duree=especeAnim.getDureeVie();
		return "nom de l'animal est "+name+ " et sa duree de vie est : "+duree +" ans";
	}

	

	@Override
	public void affichage() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Les info sur votre animal: \n"+ getName()+" ," + getOwner());
	}
	@Override
	public void setName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		this.name=name;
		
	}

	@Override
	public String getOwner() throws RemoteException {
		// TODO Auto-generated method stub
		return owner;
	}

	@Override
	public void setOwner(String owner) throws RemoteException {
		// TODO Auto-generated method stub
		this.owner=owner;
		
	}

	@Override
	public String nomComplet() throws RemoteException {
		// TODO Auto-generated method stub
			name="chat";
			owner="toto";
			return name+" , "+owner;
		
	}
	
}
