package com.example.myappsensora;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Sensor sensorAcc;
    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;

    private int movimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //definimos el tipo de sensor
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorAcc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        this.sensorAcelerometro();
        this.iniciarSensor();
    }

    public void sensorAcelerometro(){
        if(sensorAcc == null){
            Toast.makeText(this, "No cuenta con el Sensor", Toast.LENGTH_SHORT).show();
        }
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                float x = event.values[0];
                if(x < -5 && movimiento==0){
                    movimiento++;
                }
                else if(x > 5 && movimiento==1){
                    movimiento++;
                }
                if (movimiento==2){
                    sonido();
                    movimiento=0;
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    public void sonido() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.latigo);
        mediaPlayer.start();
    }

    public void iniciarSensor(){
        sensorManager.registerListener(sensorEventListener, sensorAcc, SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void detenerSensor(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        iniciarSensor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        detenerSensor();
    }
}
