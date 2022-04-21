package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.*;

public class DossierSuiviImpl extends UnicastRemoteObject implements IdossierSuivi {
	
	
	protected DossierSuiviImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}



	private static final long serialVersionUID = 1L;
	private String etatAnimal="etat initial"; 


	@Override
	public void setEtatAnimal(String etatAnimal) throws RemoteException {
		// TODO Auto-generated method stub
		this.etatAnimal=etatAnimal;
	}



	@Override
	public String getEtatAnimal() throws RemoteException {
		// TODO Auto-generated method stub
		return etatAnimal;
		
	}

}
