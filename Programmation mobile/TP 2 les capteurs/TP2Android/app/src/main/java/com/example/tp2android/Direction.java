package com.example.tp2android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Direction extends AppCompatActivity implements SensorEventListener {


    private SensorManager mSensorManager = null;
    private Sensor mAccelerometer = null;
    private TextView direction=null;
    private TextView directionR=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.direction);
        direction=findViewById(R.id.direction);
        directionR=findViewById(R.id.directionR);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorManager sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);

        Boolean supported = sensorMgr.registerListener(this,
                sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);
        if (!supported) {
            sensorMgr.unregisterListener
                    (this,sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x, y, z;
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x = event.values[0];
            if(x>0){
                //Log.v("x: droit", "droit"+x);
                directionR.setText("Droit\n"+x);
            }
            else {
                //Log.v("x: gauche", "gauche"+x);
                directionR.setText("Gauche\n"+x);
            }

            y = event.values[1];
            if(y>0) {
                //Log.v("y: haut", "haut"+y);
                direction.setText("Haut\n"+y);
            }
            else {
                //Log.v("y: bas", "bas"+y);
                direction.setText("Bas\n"+y);
            }
            z = event.values[2];
        }

    }
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}