package com.example.montrain;

import java.sql.Time;

public class Train {
    private String villeDepart;
    private String villeArrivee;
    Time dateDepart ;
    Time dateArrivee;
    public Train(String villeDepart,String villeArrivee,Time dateDepart,Time dateArrivee){
        this.dateDepart=dateDepart;
        this.dateArrivee=dateArrivee;
        this.villeArrivee=villeArrivee;
        this.villeDepart=villeDepart;
    }
    public Time getDateArrivee() {
        return dateArrivee;
    }

    public Time getDateDepart() {
        return dateDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

}
