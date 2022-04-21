package server;
import common.*;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class AnimalImp extends UnicastRemoteObject implements IAnimal {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String owner;
	private String race;
	private EspeceAnimal especeAnim;
	private DossierSuiviImpl dossierSuivi;
	
	
	//protected	DossierDeSuivi dossierSuivi = new DossierDeSuivi();
	//protected EspeceAnimal especeAnim =new EspeceAnimal("espece1",12);
    	
	protected AnimalImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AnimalImp(String name, String owner, String race) throws RemoteException {
		super();
		this.name = name;
		this.owner = owner;
		this.race=race;
	}
	
	public AnimalImp(String name, String owner, String race, EspeceAnimal especeAnim,DossierSuiviImpl dossierSuivi) throws RemoteException {
		super();
		this.name = name;
		this.owner = owner;
		this.race=race;
		this.especeAnim =especeAnim;
		this.dossierSuivi=dossierSuivi;
	}

	@Override
	public String getName()throws RemoteException{
		//name="chat";
		return this.name;
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
	
	

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
	

	/*@Override
	public String modifierDossier(String etatAnim) throws RemoteException {
			// TODO Auto-generated method stub
		String etat=dossierSuivi.modifierEtat(etatAnim);
			return etat;
	}*/

	public EspeceAnimal getEspeceAnim() {
		return especeAnim;
	}

	public void setEspeceAnim(EspeceAnimal especeAnim) {
		this.especeAnim = especeAnim;
	}

	public DossierSuiviImpl getDossierSuivi() {
		return dossierSuivi;
	}

	public void setDossierSuivi(DossierSuiviImpl dossierSuivi) {
		this.dossierSuivi = dossierSuivi;
	}


	@Override
	public String consulterEspece() throws RemoteException {
		// TODO Auto-generated method stub
		String name=especeAnim.getEspece();
		float duree=especeAnim.getDureeVie();
		return "l'espece de l'animal s'agit de : "+name+ " et sa duree de vie est : "+duree +" ans";
	}

	

	@Override
	public void affichage() throws RemoteException {
		// TODO Auto-generated method stub
		AnimalImp animal = new AnimalImp();
		
		System.out.println("Les info sur votre animal:\n nom : "+ getName()+" , Maitre: " + getOwner()+ "race: " + animal.consulterEspece());
	}
	

	

	@Override
	public String nomComplet() throws RemoteException {
		// TODO Auto-generated method stub
			//name="chat";
			//owner="toto";
			return "nom animal :" +name+" et son maitre est: , "+owner;
		
	}
	
}
