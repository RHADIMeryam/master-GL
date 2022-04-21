package server;

import java.io.Serializable;

public class EspeceAnimal implements Serializable {
	public String espece;
	public EspeceAnimal(String espece, float dureeVie) {
		super();
		this.espece = espece;
		this.dureeVie = dureeVie;
	}

	public float dureeVie=10;
	
	void setEspece(String name) {
		this.espece=name;
		
	}
	void setDureeVie(float dureeVie){
		this.dureeVie=dureeVie;
	}
	
	String getEspece() {
		return espece;
	}
	
	float getDureeVie() {
		return dureeVie;
	}
	
	

}
