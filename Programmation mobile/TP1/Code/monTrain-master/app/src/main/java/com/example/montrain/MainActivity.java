package com.example.montrain;

import androidx.appcompat.app.AppCompatActivity;

import android.net.TransportInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Train> list = new ArrayList();
        Time t1HeureDepart = Time.valueOf("18:45:20");
        Time t1HeureArrivee = Time.valueOf("22:45:20");
        Time t2H=Time.valueOf("23:35:00");
        Time t5h =Time.valueOf("02:00:00");
        Time t3H=Time.valueOf("00:30:00");
        Train tParis=new Train("Montpellier","Paris",t1HeureDepart,t1HeureArrivee);
        Train tParis2= new Train("Montpellier", "Paris",t2H,t5h);
        Train tAvignon1= new Train("Montpellier","Avignon",t1HeureArrivee, t2H);
        Train tAvignon2= new Train("Montpellier","Avignon",t2H,t3H);
       // Train t3= new Train("Paris","Montpellier",t1HeureDepart,t1HeureArrivee);
        //Train t4= new Train("Paris","Montpellier",t2H,t5h);
        list.add(tParis);list.add(tParis2);list.add(tAvignon1);list.add(tAvignon2);
        //list.add(t3);list.add(t4);


        ((Button) findViewById(R.id.b)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView resultat= findViewById(R.id.resultat);
                        TextView villeDepart= findViewById(R.id.depart);
                        String depart = villeDepart.getText().toString();
                        TextView villeArrivee= findViewById(R.id.ar);
                        String arrivee= villeArrivee.getText().toString();

                        if(depart.equals("Montpellier") &&  arrivee.equals("Paris")) {
                            resultat.setText("                " +tParis.getVilleDepart() + "--->" + tParis.getVilleArrivee() + "\n"
                                    + "Date départ :" + tParis.getDateDepart() + "\nDate d'arrivéé:" + tParis.getDateArrivee()+"\n"+
                                    "                " + tParis2.getVilleDepart() + "--->" + tParis2.getVilleArrivee() + "\n"
                                    + "Date départ :" + tParis2.getDateDepart() + "\nDate d'arrivéé:" + tParis2.getDateArrivee()
                            );

                        }
                        //resultat.setText("hi");
                        if(depart.equals("Montpellier") &&  arrivee.equals("Avignon")) {
                            resultat.setText("                " +tAvignon1.getVilleDepart() + "--->" + tAvignon1.getVilleArrivee() + "\n"
                                    + "Date départ :" + tAvignon1.getDateDepart() + "\nDate d'arrivéé:" + tAvignon1.getDateArrivee()+"\n"+
                                    "                " + tAvignon2.getVilleDepart() + "--->" + tAvignon2.getVilleArrivee() + "\n"
                                    + "Date départ :" + tAvignon2.getDateDepart() + "\nDate d'arrivéé:" + tAvignon2.getDateArrivee()
                            );

                        }
                        else {
                            resultat.setText("Trajet non dispo pour le moment");
                        }
                    }
                });
    }

}