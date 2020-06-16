package com.example.myappbdsw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnInsertar:
                Intent intent = new Intent(getApplicationContext(), InsertarActivity.class);
                startActivity(intent);
                break;
            case  R.id.btnMostrar:
                Intent intent1 = new Intent(getApplicationContext(), MostrarActivity.class);
                startActivity(intent1);
                break;
            case  R.id.btnEliminar:
                Intent intent2 = new Intent(getApplicationContext(), EliminarActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
