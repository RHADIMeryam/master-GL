package com.example.tp2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Proximity extends AppCompatActivity  {

    TextView etat;
    SensorManager sensorManager;
    Sensor proximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proximity);
        etat = findViewById(R.id.etat);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (proximity == null) {
            Toast.makeText(this, "Vous avez pas ce capteur sur votre appareil", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            // registering our sensor with sensor manager.
            sensorManager.registerListener(proximitySensorEventListener,
                    proximity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    SensorEventListener proximitySensorEventListener = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            ImageView away = findViewById(R.id.away);
            ImageView near = findViewById(R.id.near);
            away.setVisibility(View.INVISIBLE);
            near.setVisibility(View.INVISIBLE);
            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                if (event.values[0] == 0) {
                    etat.setText("Near");
                    near.setVisibility(View.VISIBLE);

                } else {
                    etat.setText("Away");
                    away.setVisibility(View.VISIBLE);
                }
            }
        }
    };
}