package com.example.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Recherche {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRecherche;
	//@OneToMany(mappedBy="hotel",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	//@OneToMany(targetEntity=Hotel.class,mappedBy="recherche")
	//private List<Hotel> hotels;
	
	public Recherche() {
	}
	public Recherche(int idRecherche, List<Hotel> hotels) {
		this.idRecherche = idRecherche;
	//	this.hotels = hotels;
	}
	public int getIdRecherche() {
		return idRecherche;
	}
	public void setIdRecherche(int idRecherche) {
		this.idRecherche = idRecherche;
	}
	/*public List<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}*/
	/*@Override
	public int hashCode() {
		return Objects.hash(hotels, idRecherche);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recherche other = (Recherche) obj;
		return Objects.equals(hotels, other.hotels) && idRecherche == other.idRecherche;
	}
	@Override
	public String toString() {
		return "Recherche [idRecherche=" + idRecherche + ", hotels=" + hotels + "]";
	}*/
           
}
