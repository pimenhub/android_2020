package com.example.myapp12_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //Es el que nos permite realizar la trasacciones entre fragment
    FragmentTransaction transaction;
    Fragment f1, f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciamos los fragmentos
        f1 = new Fragment_1();
        f2 = new Fragment_2();

        //Definimos que fragmento va a salir desde el inicio de la app
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorId,f1).commit();

    }

    public void onClick(View view) {
    transaction = getSupportFragmentManager().beginTransaction();
    switch (view.getId())
    {
        case R.id.btnF1:
            //transaction.replace(R.id.contenedorId,f1);
            //transaction.addToBackStack(null);
            if(f1.isAdded()){
                transaction.hide(f2).show(f1);
            }
            else {
                transaction.hide(f2).add(R.id.contenedorId, f1);
                transaction.addToBackStack(null);
            }
            break;
        case R.id.btnF2:
            //transaction.replace(R.id.contenedorId,f2);
            //transaction.addToBackStack(null);
            if(f2.isAdded()){
                transaction.hide(f1).show(f2);
            }
            else {
                transaction.hide(f1).add(R.id.contenedorId, f2);
                transaction.addToBackStack(null);
            }
            break;
    }
    transaction.commit();


    }
}
