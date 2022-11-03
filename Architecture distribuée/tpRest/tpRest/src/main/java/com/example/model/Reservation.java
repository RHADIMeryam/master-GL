package com.example.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReservation;
	@Column(name = "dateDebutSejour")
	private Date dateDebutSejour;
	@Column(name = "dateFinSejour")
	private Date dateFinSejour;
	@Column(name = "nbrLits")
	private int nbrLits;
	@Column(name = "nbrPers")
	private int nbrPers;
	@Column(name = "prixTotal")
	private Double prixTotal;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="chambre_id",referencedColumnName="idChambre")
	private Chambre chambreReserver;
	
	public Chambre getChambreReserver() {
		return chambreReserver;
	}
	public void setChambreReserver(Chambre chambreReserver) {
		this.chambreReserver = chambreReserver;
	}
	public Reservation() {
		super();
	}
	public Reservation(Date dateDebutSejour, Date dateFinSejour, int nbrLits, int nbrPers,
			Double prixTotal, Client client) {
		super();
		this.dateDebutSejour = dateDebutSejour;
		this.dateFinSejour = dateFinSejour;
		this.nbrLits = nbrLits;
		this.nbrPers = nbrPers;
		this.prixTotal = prixTotal;
		//this.client = client;
	}
	public int getIdReservation() {
		return idReservation;
	}
	/* public Double calculerPrixTotale(Chambre c) {
		
		try {
			long diff = d2.getTime() - c.getDateDisponabilite();
		    Date date1 = c.getDateDisponabilite();
		    
		    long daysBetween = Duration.between(date1, date2).toDays();
		    System.out.println ("Days: " + daysBetween);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
	}*/
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	public Date getDateDebutSejour() {
		return dateDebutSejour;
	}
	public void setDateDebutSejour(Date dateDebutSejour) {
		this.dateDebutSejour = dateDebutSejour;
	}
	public Date getDateFinSejour() {
		return dateFinSejour;
	}
	public void setDateFinSejour(Date dateFinSejour) {
		this.dateFinSejour = dateFinSejour;
	}
	public int getNbrLits() {
		return nbrLits;
	}
	public void setNbrLits(int nbrLits) {
		this.nbrLits = nbrLits;
	}
	public int getNbrPers() {
		return nbrPers;
	}
	public void setNbrPers(int nbrPers) {
		this.nbrPers = nbrPers;
	}
	public Double getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}
	/*public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}*/
	/*@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", dateDebutSejour=" + dateDebutSejour
				+ ", dateFinSejour=" + dateFinSejour + ", nbrLits=" + nbrLits + ", nbrPers=" + nbrPers + ", prixTotal="
				+ prixTotal + ", client=" + client + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(client, dateDebutSejour, dateFinSejour, idReservation, nbrLits, nbrPers, prixTotal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(client, other.client) && Objects.equals(dateDebutSejour, other.dateDebutSejour)
				&& Objects.equals(dateFinSejour, other.dateFinSejour) && idReservation == other.idReservation
				&& nbrLits == other.nbrLits && nbrPers == other.nbrPers && Objects.equals(prixTotal, other.prixTotal);
	}	

*/
}
