package com.example.locationprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.locationprojet.model.Utilisateur;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Inscription extends AppCompatActivity {

    private Button inscrire,connexion;
    private TextInputLayout username,email,password,numero;
    private RadioButton annonceur, acheteur;
    private FirebaseDatabase rootNode;
    private DatabaseReference userdataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inscription);
        //recupération des informations
        inscrire=findViewById(R.id.inscrire);
        connexion=findViewById(R.id.seConnecter);
        username=findViewById(R.id.usernameI);
        email=findViewById(R.id.emailI);
        password=findViewById(R.id.passwordI);
        numero=findViewById(R.id.numeroI);
        annonceur=findViewById(R.id.annonceur);
        acheteur=findViewById(R.id.acheteur);
        rootNode=FirebaseDatabase.getInstance();
        userdataBase =rootNode.getReference("utilisateur");
        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inscription.this, Connexion.class);
                startActivity(intent);
            }
        });
        inscrire.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
               inscription(view);
           }
        });
    }
    public Boolean verifierUsername(){
        String val=username.getEditText().getText().toString();
        if(val.isEmpty()){
            username.setError("username doit pas etre vide");
            return false;
        }else{
            username.setError(null);
            return true;
        }
    }
    public Boolean verifierPassword(){
        String val=password.getEditText().getText().toString();
        if(val.isEmpty()){
            password.setError("password doit pas etre vide");
            return false;
        }else{
            password.setError(null);
            return true;
        }
    }
    public Boolean verifierEmail(){
        String val=email.getEditText().getText().toString();
        if(val.isEmpty()){
            email.setError("email doit pas etre vide");
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }
    public Boolean verifierTel(){
        String val=numero.getEditText().getText().toString();
        if(val.isEmpty()){
            numero.setError("numero doit pas etre vide");
            return false;
        }else{
            numero.setError(null);
            return true;
        }
    }

    //fonction pour enregistrer un user
    public void inscription(View view){
        if( verifierEmail() && verifierUsername() &&verifierTel() && verifierPassword()) {
            String usernameS = username.getEditText().getText().toString();
            String emailS = email.getEditText().getText().toString();
            String passwordS = password.getEditText().getText().toString();
            String numeroS = numero.getEditText().getText().toString();
            String annonceurS=annonceur.getText().toString();
            String acheteurS=acheteur.getText().toString();

            if(annonceur.isChecked()){
                Utilisateur utilisateur = new Utilisateur(usernameS, emailS, numeroS, passwordS,annonceurS);
                userdataBase.child(usernameS).setValue(utilisateur);

                Intent intent = new Intent(Inscription.this, Home.class);
                startActivity(intent);
            }
            if(acheteur.isChecked()){
                Utilisateur utilisateur = new Utilisateur(usernameS, emailS, numeroS, passwordS,acheteurS);
                userdataBase.child(usernameS).setValue(utilisateur);
                Intent intent = new Intent(Inscription.this, Home.class);
                startActivity(intent);
            }
        }
    }

}