package com.example.locationprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=4000;

    //Animation
    Animation topAnimation, bottomAnimation;
    ImageView image;
    TextView titre,slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Animation
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.animation_t);
        bottomAnimation=AnimationUtils.loadAnimation(this, R.anim.animation_b);
        image=findViewById(R.id.image);
        titre=findViewById(R.id.titre);
        slogan=findViewById(R.id.slogan);
        image.setAnimation(topAnimation);
        titre.setAnimation(bottomAnimation);
        slogan.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
             Intent intent = new Intent(MainActivity.this, Connexion.class);
             startActivity(intent);
             finish();
        }
    },SPLASH_SCREEN);

    }
}
