package com.example.locationprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UserInfo extends AppCompatActivity {

    private Button enregistrer,retour;
    private String usernameSaission, emailSession,phoneSession,typeSaisson;
    private TextInputLayout email,user,tel,typeprofile;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference("utilisateur");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        retour=findViewById(R.id.retour);
        email=findViewById(R.id.emailV);
        user=findViewById(R.id.usernameV);
        tel=findViewById(R.id.numeroV);
        typeprofile=findViewById(R.id.typeV);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfo.this, Home.class);
                startActivity(intent);
            }
        });
        SessionManager sessionManager= new SessionManager(this);
        HashMap<String,String> userDetails= sessionManager.getUserDetailFromSession();
        usernameSaission=userDetails.get(SessionManager.KEY_USERNAME);
        emailSession=userDetails.get(SessionManager.KEY_EMAIL);
        phoneSession=userDetails.get(SessionManager.KEY_PHONE);
        typeSaisson=userDetails.get(SessionManager.KEY_TYPEPROFILE);
        //modifier dans vue
        email.getEditText().setText(emailSession);
        user.getEditText().setText(usernameSaission);
        tel.getEditText().setText(phoneSession);
        typeprofile.getEditText().setText(typeSaisson);

    }

    private void afficherUser() {
        Intent intent1 = getIntent();
        String usernameRecup=intent1.getStringExtra("username");
        String emailRecup=intent1.getStringExtra("email");
        String phoneRecup=intent1.getStringExtra("numero");
        String passwordRecup=intent1.getStringExtra("password");


    }

}