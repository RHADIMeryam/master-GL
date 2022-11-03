package com.example.tp1exercice2helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEnfant extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enfant);
        Intent intent = getIntent();


        TextView nomEdit = (TextView) findViewById(R.id.textViewNomRet);
        TextView prenomEdit = (TextView) findViewById(R.id.textView7);
        TextView ageEdit = (TextView) findViewById(R.id.textViewAgeRet);
        TextView competenceEdit = (TextView) findViewById(R.id.textViewCompRet);
        TextView telEdit = (TextView) findViewById(R.id.textViewTelRet);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nom = extras.getString("nom");
            String prenom = extras.getString("prenom");
            String age = extras.getString("age");
            String competence = extras.getString("competence");
            String tel = extras.getString("tel");

            nomEdit.setText("Bonjour " + nom + " " + prenom);
            //  prenomEdit.setText("Salut "+prenom);
            ageEdit.setText("Votre age est : " + age);
            competenceEdit.setText("Votre compétence est : " + competence);
            telEdit.setText("Votre numéro de tel est : " + tel);

        }
        Button btnOk = (Button) findViewById(R.id.boutonOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(ActivityEnfant.this, ActivityVide.class);
                startActivity(intent);
 }
        });

        Button btnRetour = (Button) findViewById(R.id.boutonRetour);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();        }
        });
    }

    }