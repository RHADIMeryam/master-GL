package com.example.locationprojet;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Connexion extends AppCompatActivity {

    private Button nvUtilisateur,seConnecter;
    private TextInputLayout username, password;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference userdataBase = database.getReference("utilisateur");
    private String emailFromDb,numeroFromDb,usernameFromDb,typeProfileFromdb;
    private String usernameSaisi,passwordSaisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        nvUtilisateur = findViewById(R.id.Sinscrire);
        seConnecter=findViewById(R.id.connecterC);
        username = findViewById(R.id.usernameC);
        password = findViewById(R.id.passwordC);
        nvUtilisateur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Connexion.this, Inscription.class);
                startActivity(intent);
            }
        });

        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               login(view);
            }
        });
    }

    public Boolean verifierPassword(){
        String val=password.getEditText().getText().toString();
        if(val.isEmpty() ){
            password.setError("Le mot de passe peut pas etre vide");
            return false;
        }else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public Boolean verifierUsername(){
        String val=username.getEditText().getText().toString();
        if(val.isEmpty()){
            username.setError("Username ne peut pas etre vide");
            return false;
        }else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }
    public void login(View view){
        if(verifierPassword() && verifierUsername()){
            authentification();
        }
    }
    public void authentification() {
         usernameSaisi = username.getEditText().getText().toString().trim();
         passwordSaisi = password.getEditText().getText().toString().trim();
         Query verifierUtilisateur = userdataBase.orderByChild("username").equalTo(usernameSaisi);

        verifierUtilisateur.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               if(snapshot.exists()){
                   username.setError(null);
                   username.setErrorEnabled(false);
                   String passwordFromDb=snapshot.child(usernameSaisi).child("password").getValue(String.class);
                   if(passwordFromDb.equals(passwordSaisi)){
                       username.setError(null);
                       username.setErrorEnabled(false);
                       emailFromDb=snapshot.child(usernameSaisi).child("email").getValue(String.class);
                       numeroFromDb=snapshot.child(usernameSaisi).child("numero").getValue(String.class);
                       usernameFromDb=snapshot.child(usernameSaisi).child("username").getValue(String.class);
                       typeProfileFromdb=snapshot.child(usernameSaisi).child("typeP").getValue(String.class);
                       //create session
                       SessionManager sessionManager= new SessionManager(Connexion.this);
                       sessionManager.createLoginSession(usernameFromDb, emailFromDb, numeroFromDb,passwordFromDb,typeProfileFromdb);
                       startActivity(new Intent(getApplicationContext(),Home.class));
                       //Intent intent = new Intent(Connexion.this, Home.class);
                       // startActivity(intent);
                   }
                   else{
                       password.setError("mot de passe incorrect");
                       password.requestFocus();
                   }
               }
               else{
                   username.setError("Cette utilisateur n'existe pas");
                   username.requestFocus();
               }
           }
           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
    }
}