package fr.uavignon.ceri.tp3.data;

public class Forecast{
    public final String pays;
    public final String ville;
    public final int temperature;
    public final int humudite;
    public final int vent;
    public final int nebulosite;
    public final String icon;
    public Forecast(String pays, String ville, int temperature, int humudite, String icon, int vent , int nebulosite) {
        this.pays = pays;
        this.ville = ville;
        this.temperature = temperature;
        this.humudite = humudite;
        this.icon = icon;
        this.vent = vent;
        this.nebulosite=nebulosite;
    }
}