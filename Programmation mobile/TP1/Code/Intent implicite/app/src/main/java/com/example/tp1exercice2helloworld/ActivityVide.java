package com.example.tp1exercice2helloworld;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityVide extends AppCompatActivity {
    Intent intent_call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecran_vide);
        Intent intent = getIntent();
        TextView numAffiche = (TextView) findViewById(R.id.number);

        Bundle extras = getIntent().getExtras();
        String num = extras.getString("num");

        numAffiche.setText(num);

        Button btnAppel = (Button) findViewById(R.id.btnAppel);

        btnAppel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                call(num);
            }
        });

    }
    private void call (String num) {
         intent_call = new Intent(Intent.ACTION_CALL);
        intent_call.setData(Uri.parse("tel:" + num));
        startActivity(intent_call);
    }}
