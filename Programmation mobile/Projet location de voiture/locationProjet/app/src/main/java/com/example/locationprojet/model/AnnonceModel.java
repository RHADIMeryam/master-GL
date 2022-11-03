package com.example.locationprojet.model;

public class AnnonceModel {


    private String id, image,description,nomVoiture, modele,prix,addr,telephone,username;
    private AnnonceModel annonce;
    public AnnonceModel(){}
    public AnnonceModel(String id, String image, String nomVoiture, String modele, String prix, String description, String addresse, String telephone,String username){
        this.image=image;
        this.nomVoiture=nomVoiture;
        this.modele=modele;
        this.prix=prix;
        this.description=description;
        this.addr=addresse;
        this.telephone=telephone;
        this.id=id;
        this.username=username;
    }

    public AnnonceModel(String id, String image, String nomVoiture, String modele, String prix, String description, String addresse, String telephone){
        this.image=image;
        this.nomVoiture=nomVoiture;
        this.modele=modele;
        this.prix=prix;
        this.description=description;
        this.addr=addresse;
        this.telephone=telephone;
        this.id=id;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AnnonceModel getAnnonce() {
        return annonce;
    }

    public void setAnnonce(AnnonceModel annonce) {
        this.annonce = annonce;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomVoiture() {
        return nomVoiture;
    }

    public void setNomVoiture(String nomVoiture) {
        this.nomVoiture = nomVoiture;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

