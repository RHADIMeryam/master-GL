package tp1.exo9.monAgenda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Evenement {

    public static ArrayList<Evenement> listEvenement = new ArrayList<>();

    public static ArrayList<Evenement> evenementDeDate(LocalDate date)
    {
        ArrayList<Evenement> evenements = new ArrayList<>();

        for(Evenement event : listEvenement)
        {
            if(event.getDate().equals(date))
                evenements.add(event);
        }

        return evenements;
    }


    private String nom;
    private LocalDate date;
    private LocalTime temps;

    public Evenement(String nom, LocalDate date, LocalTime temps)
    {
        this.nom = nom;
        this.date = date;
        this.temps = temps;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTemps()
    {
        return temps;
    }

    public void setTemps(LocalTime temps)
    {
        this.temps = temps;
    }


}
