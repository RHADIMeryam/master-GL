package com.example.tp1exercice2helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.monBouton)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        afficherBoiteDeDialogue();                    }
                });

        /*LinearLayout monLinearLayout = new LinearLayout(this) ;
        monLinearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView tv1 = new TextView(this);
        tv1.setText("Nom");
        EditText et1= new EditText(this);
        TextView tv2 = new TextView(this);
        tv2.setText("Prenom");
        EditText et2= new EditText(this);
        TextView tv3 = new TextView(this);
        tv3.setText("Age");
        EditText et3= new EditText(this);
        TextView tv4 = new TextView(this);
        tv4.setText("Domaine de competence");
        EditText et4= new EditText(this);
        TextView tv5 = new TextView(this);
        tv5.setText("Numero de telephone");
        EditText et5= new EditText(this);
        Button b = new Button(this);
        b.setText("Valider");
        monLinearLayout.addView(tv1);
        monLinearLayout.addView(et1);
        monLinearLayout.addView(tv2);
        monLinearLayout.addView(et2);
        monLinearLayout.addView(tv3);
        monLinearLayout.addView(et3);
        monLinearLayout.addView(tv4);
        monLinearLayout.addView(et4);
        monLinearLayout.addView(tv5);
        monLinearLayout.addView(et5);
        monLinearLayout.addView(b);
        setContentView(monLinearLayout);*/

    }


    public void afficherBoiteDeDialogue() {
        DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickBoiteDeDialogue(dialog, which);
            }
        };

        new AlertDialog.Builder(this)
                .setTitle("Ma boite")
                .setMessage("Voulais vous valider l'enregistrement ?")
                .setPositiveButton("Confirmer", dialogListener)
                .setNegativeButton("Annuler", dialogListener)
                .show();
    }

    private void onClickBoiteDeDialogue(DialogInterface dialog, int which) {
        switch (which) {
            case AlertDialog.BUTTON_POSITIVE:
                new AlertDialog.Builder(this).setMessage("Choix confirmé !").show();
                break;

            case AlertDialog.BUTTON_NEGATIVE:
                new AlertDialog.Builder(this).setMessage("Choix annulé !").show();
                break;
        }
    }
}