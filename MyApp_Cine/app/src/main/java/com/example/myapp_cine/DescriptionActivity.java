package com.example.myapp_cine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DescriptionActivity extends AppCompatActivity {
    private FragmentTransaction fragmentTransaction;
    private Fragment f1, f2, f3;

    private ImageView imagenDes;
    private TextView nombreDes;

    private String nombre;
    private int imagen;

    private String sinopsis;
    private String directores;
    private String actores;

    private String puntua;
    private String recauda;

    private int precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        imagenDes = findViewById(R.id.imgDes);
        nombreDes = findViewById(R.id.nombreDes);


        f1 = new SinopFragment();
        f2 = new DirectFragment();
        f3 = new PuntuaFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFr,f3).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFr,f2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFr,f1).commit();

        //Llamar metodos
        this.recibirDatos();
        this.datosParaFragments1();
        this.datosParaFragments2();
        this.datosParaFragments3();
    }
    public void recibirDatos(){
        Bundle bundle = getIntent().getExtras();
        imagen = bundle.getInt("img");
        nombre = bundle.getString("nombre");
        //Recibir los datos extras
        sinopsis = bundle.getString("sinopsis");
        directores = bundle.getString("directores");
        actores = bundle.getString("actores");

        puntua = bundle.getString("puntuacion");
        recauda = bundle.getString("recaudacion");

        precio = bundle.getInt("precioB");

        imagenDes.setImageResource(imagen);
        nombreDes.setText(nombre);

    }


    public void datosParaFragments1(){
        Bundle bundleDatos = new Bundle();
        bundleDatos.putString("sinop", sinopsis);
        f1.setArguments(bundleDatos);
    }


    public void datosParaFragments2(){
        Bundle bundleDatos = new Bundle();
        bundleDatos.putString("directores", directores);
        bundleDatos.putString("actores", actores);

        f2.setArguments(bundleDatos);
    }

    public void datosParaFragments3(){
        Bundle bundleDatos = new Bundle();
        bundleDatos.putString("puntuacion", puntua);
        bundleDatos.putString("recaudacion", recauda);

        f3.setArguments(bundleDatos);
    }

    public void onClick(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btnFrm1:
                if (f1.isAdded()){
                    fragmentTransaction.hide(f3).hide(f2).show(f1);
                }
                else {
                    fragmentTransaction.hide(f3).hide(f2).add(R.id.contenedorFr, f1);
                    fragmentTransaction.addToBackStack(null);
                }
                break;
            case R.id.btnFrm2:
                if (f2.isAdded()){
                    fragmentTransaction.hide(f3).hide(f1).show(f2);
                }
                else {
                    fragmentTransaction.hide(f3).hide(f1).add(R.id.contenedorFr, f2);
                    fragmentTransaction.addToBackStack(null);
                }
                break;
            case R.id.btnFrm3:
                if (f3.isAdded()){
                    fragmentTransaction.hide(f2).hide(f1).show(f3);
                }
                else {
                    fragmentTransaction.hide(f2).hide(f1).add(R.id.contenedorFr, f3);
                    fragmentTransaction.addToBackStack(null);
                }
                break;
            case R.id.imgDes:
                Intent intent = new Intent(getApplicationContext(), ImagenActivity.class);
                intent.putExtra("imgF", imagen);
                startActivity(intent);
                break;
            case R.id.comprarId:
                Intent intent1 = new Intent(getApplicationContext(), ReciboActivity.class);
                intent1.putExtra("precioBoleto", precio);
                startActivity(intent1);
                break;
            default:
                Toast.makeText(this, "Información no detallada", Toast.LENGTH_SHORT).show();
                break;
        }
        fragmentTransaction.commit();
    }
}
