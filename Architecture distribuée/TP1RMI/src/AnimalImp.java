import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AnimalImp extends UnicastRemoteObject implements IAnimal {

	
	
	String name;
	String owner;
	String espece;
	String race;
	
	protected	DossierDeSuivi dossierSuivi = new DossierDeSuivi();
	protected EspeceAnimal especeAnim =new EspeceAnimal();
	
	protected AnimalImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String afficherName()   throws RemoteException{
		name="chat";
		return name;
	}
	@Override
	public String afficherNameAndOwner()  throws RemoteException {
		name="chat";
		owner="toto";
		return name+"  "+owner;
	}

	@Override
	public String modifierDossier(String etatAnim) throws RemoteException {
			// TODO Auto-generated method stub
		String etat=dossierSuivi.modifierEtat(etatAnim);
			return etat;
	}

	@Override
	public String consulterEspece() throws RemoteException {
		// TODO Auto-generated method stub
		String name=especeAnim.getName();
		float duree=especeAnim.getDureeVie();
		return "nom de l'animal est "+name+ " et sa duree de vie est : "+duree +" ans";
	}
	
}
