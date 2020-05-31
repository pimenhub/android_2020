package com.example.myapp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }oo

    public void onClickA1(View view) {
        finish();
        Intent intento = new Intent(this,IntermediaActivity.class);
        startActivity(intento);
    }
}
