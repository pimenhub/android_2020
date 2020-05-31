package com.example.myapp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntermediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermedia);
    }

    public void onClickA2(View view) {
        Intent intento= null;
        switch (view.getId()){
            case R.id.btnRegresar:
                finish();
                intento = new Intent(this,MainActivity.class);
                startActivity(intento);
                break;
            case  R.id.btnSiguiente:

                intento = new Intent(this, FinalActivity.class);
                startActivity(intento);
                break;

        }


    }
}
