package com.example.myappsensor_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Definicion de obtejetos para activar los sensores
    private Sensor sensor;
    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;
    private int movimiento;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        // se define el uso de los sensores
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //this.senosorDeProximidad();
        this.sensorAcelerometro();
        this.iniciarSensorA();
        //this.iniciarSensorP();
    }


    public void senosorDeProximidad(){
        if(sensor == null){
            Toast.makeText(this, "No hya sensor", Toast.LENGTH_SHORT).show();
        }
        sensorEventListener = new SensorEventListener() {
            //Realiza los cambios del sensonr
            @Override
            public void onSensorChanged(SensorEvent event) {
                //validar el rango
                if(event.values[0]<sensor.getMaximumRange()){
                    //getWindow().getDecorView().setBackgroundColor(Color.RED);
                    img.setImageResource(R.drawable.ic_launcher_foreground);
                }
                else {
                    img.setImageResource(0);
                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    public void sensorAcelerometro(){
        if(sensor == null){
            Toast.makeText(this, "No hya sensor", Toast.LENGTH_SHORT).show();
        }
        sensorEventListener = new SensorEventListener() {
            //Realiza los cambios del sensonr
            @Override
            public void onSensorChanged(SensorEvent event) {
                //definimos los ejes del sensor
                float x= event.values[0];
                if(x < -5 && movimiento==0){
                    getWindow().getDecorView().setBackgroundColor(Color.BLACK);
                movimiento++;
                }
                else if(x > 5 && movimiento==1){
                    getWindow().getDecorView().setBackgroundColor(Color.GRAY);
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
    public void sonido(){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.latigo);
        mediaPlayer.start();
    }
    //Metodos para iniciar y detener el sensor
    public void iniciarSensorP(){
        sensorManager.registerListener(sensorEventListener, sensor, 2000*1000);
    }
    public void detenerSensorP(){
        sensorManager.unregisterListener(sensorEventListener);
    }
    public void iniciarSensorA(){
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void detenerSensorA(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.iniciarSensorP();
        this.iniciarSensorA();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.detenerSensorP();
        this.detenerSensorP();
    }

}
