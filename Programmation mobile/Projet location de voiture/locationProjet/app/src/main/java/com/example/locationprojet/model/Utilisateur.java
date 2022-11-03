package com.example.locationprojet.model;

import com.example.locationprojet.Annonce;

public class Utilisateur {

    private String username;
    private String email;
    private String numero;
    private String password;
    private String typeP;
    private String image;



    public Utilisateur() {}
    public Utilisateur(String username, String email, String numero, String password,String typeP) {
        this.username = username;
        this.email = email;
        this.numero = numero;
        this.password = password;
        this.typeP = typeP;

    }
    public Utilisateur(String username, String email, String numero, String password,String typeP,String image) {
        this.username = username;
        this.email = email;
        this.numero = numero;
        this.password = password;
        this.typeP = typeP;
        this.image=image;


    }


    public Utilisateur(String username, String email, String numero, String password, Annonce annonce) {
        this.username = username;
        this.email = email;
        this.numero = numero;
        this.password = password;
        this.typeP = typeP;
    }


    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeP() {
        return typeP;
    }

    public void setTypeP(String typeP) {
        this.typeP = typeP;
    }
}
