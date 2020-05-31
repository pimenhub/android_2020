package com.example.myapp_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MesesActivity extends AppCompatActivity {

    private TextView campoM, campoN;
    private String mes;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meses);

        campoM = findViewById(R.id.txtMes);
        campoN = findViewById(R.id.txtNum);


        this.meses();
    }


    private void meses(){
        Bundle bundle = getIntent().getExtras();
        mes = bundle.getString("dato");
        num = bundle.getInt("numero");
        campoM.setText(mes);
        campoN.setText("Mes no. "+num);

    }
}
