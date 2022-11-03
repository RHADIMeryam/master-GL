package com.example.locationprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

public class Home extends AppCompatActivity {

    private Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new AnnonceFragement()).commit();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        SessionManager sessionManager= new SessionManager(this);
        HashMap<String,String> userDetails= sessionManager.getUserDetailFromSession();
        String  usernameSaisson=userDetails.get(SessionManager.KEY_USERNAME);
        String type=userDetails.get(SessionManager.KEY_TYPEPROFILE);
       // bottomNavigationView.findViewById(R.id.userView).setVisibility(View.GONE);
        System.out.println("My type is "+type);
        if(type.equals("Acheteur")){
            bottomNavigationView.findViewById(R.id.plus).setVisibility(View.GONE);
            bottomNavigationView.findViewById(R.id.listAnnonce).setVisibility(View.GONE);

        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.plus:
                         Intent plus = new Intent(Home.this, Annonce.class);
                         startActivity(plus);
                         break;
                    case R.id.userView:
                        Intent userView = new Intent(Home.this, UserInfo.class);
                        startActivity(userView);
                        break;
                    case R.id.listAnnonce:
                        Intent listAnnonce = new Intent(Home.this, HomeUser.class);
                        startActivity(listAnnonce);
                        break;
                    case R.id.home:
                        Intent home = new Intent(Home.this, Home.class);
                        startActivity(home);
                        break;
                }

                return true;
            }

        });




    }
    }

