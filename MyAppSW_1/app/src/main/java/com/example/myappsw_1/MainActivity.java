package com.example.myappsw_1;

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
                Intent intent = new Intent(getApplicationContext(),InsertarActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMostrarLista:
                Intent intent2 = new Intent(getApplicationContext(),MostrarListaActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
