package com.example.myapp_cine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ArrayList<PeliculasVo> lista_p = new ArrayList<>();
    ArrayList<PeliculasVo> lista_e = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cartelera");


        //RecyclerView
        recyclerView = findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Metodo para llenar el item del recycler
        this.llenarItem();

        //Abstraer la clase del Adaptador personalizado
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(lista_p) ;

        //Datos Extras
        this.llenarDatosExtras();

        //clic en el recycler
        adaptadorRecycler.setOnItemClickListener(new AdaptadorRecycler.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                switch (position){
                    case 0:
                        Intent intent0 = new Intent(getApplicationContext(), DescriptionActivity.class);
                        intent0.putExtra("img", lista_p.get(position).getImg());
                        intent0.putExtra("nombre", lista_p.get(position).getNombre());

                        intent0.putExtra("sinopsis", lista_e.get(position).getSinopsis());
                        intent0.putExtra("directores", lista_e.get(position).getDirectores());

                        intent0.putExtra("actores", lista_e.get(position).getActores());

                        intent0.putExtra("puntuacion", lista_e.get(position).getPuntuacion());
                        intent0.putExtra("recaudacion", lista_e.get(position).getRecaudacion());

                        intent0.putExtra("precioB", 55);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), DescriptionActivity.class);
                        intent1.putExtra("img", lista_p.get(position).getImg());
                        intent1.putExtra("nombre", lista_p.get(position).getNombre());

                        intent1.putExtra("sinopsis", lista_e.get(position).getSinopsis());
                        intent1.putExtra("directores", lista_e.get(position).getDirectores());

                        intent1.putExtra("actores", lista_e.get(position).getActores());

                        intent1.putExtra("puntuacion", lista_e.get(position).getPuntuacion());
                        intent1.putExtra("recaudacion", lista_e.get(position).getRecaudacion());

                        intent1.putExtra("precioB", 35);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), DescriptionActivity.class);
                        intent2.putExtra("img", lista_p.get(position).getImg());
                        intent2.putExtra("nombre", lista_p.get(position).getNombre());

                        intent2.putExtra("sinopsis", lista_e.get(position).getSinopsis());
                        intent2.putExtra("directores", lista_e.get(position).getDirectores());

                        intent2.putExtra("actores", lista_e.get(position).getActores());

                        intent2.putExtra("puntuacion", lista_e.get(position).getPuntuacion());
                        intent2.putExtra("recaudacion", lista_e.get(position).getRecaudacion());

                        intent2.putExtra("precioB", 45);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getApplicationContext(), DescriptionActivity.class);
                        intent3.putExtra("img", lista_p.get(position).getImg());
                        intent3.putExtra("nombre", lista_p.get(position).getNombre());

                        intent3.putExtra("sinopsis", lista_e.get(position).getSinopsis());
                        intent3.putExtra("directores", lista_e.get(position).getDirectores());

                        intent3.putExtra("actores", lista_e.get(position).getActores());

                        intent3.putExtra("puntuacion", lista_e.get(position).getPuntuacion());
                        intent3.putExtra("recaudacion", lista_e.get(position).getRecaudacion());

                        intent3.putExtra("precioB", 40);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getApplicationContext(), DescriptionActivity.class);
                        intent4.putExtra("img", lista_p.get(position).getImg());
                        intent4.putExtra("nombre", lista_p.get(position).getNombre());

                        intent4.putExtra("sinopsis", lista_e.get(position).getSinopsis());
                        intent4.putExtra("directores", lista_e.get(position).getDirectores());

                        intent4.putExtra("actores", lista_e.get(position).getActores());

                        intent4.putExtra("puntuacion", lista_e.get(position).getPuntuacion());
                        intent4.putExtra("recaudacion", lista_e.get(position).getRecaudacion());

                        intent4.putExtra("precioB", 37);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getApplicationContext(), DescriptionActivity.class);
                        intent5.putExtra("img", lista_p.get(position).getImg());
                        intent5.putExtra("nombre", lista_p.get(position).getNombre());

                        intent5.putExtra("sinopsis", lista_e.get(position).getSinopsis());
                        intent5.putExtra("directores", lista_e.get(position).getDirectores());

                        intent5.putExtra("actores", lista_e.get(position).getActores());

                        intent5.putExtra("puntuacion", lista_e.get(position).getPuntuacion());
                        intent5.putExtra("recaudacion", lista_e.get(position).getRecaudacion());

                        intent5.putExtra("precioB", 42);
                        startActivity(intent5);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "No se ha selecionado nínguna Pelicula", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        recyclerView.setAdapter(adaptadorRecycler);

    }

    //Metodos para la Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemT_1:
                recyclerView.setLayoutManager(new GridLayoutManager(this,2));
                break;
            case R.id.itemT_2:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //Metodos del RecyclerView
    public void llenarItem(){
        lista_p.add(new PeliculasVo("Vengadores EndGame","3h 02m", R.drawable.portada1));
        lista_p.add(new PeliculasVo("Glass", "2h 9m", R.drawable.portada2));
        lista_p.add(new PeliculasVo("Toy Story 4", "1h 40m", R.drawable.portada3));
        lista_p.add(new PeliculasVo("Aladdin", "2h 8m", R.drawable.portada4));
        lista_p.add(new PeliculasVo("John Wick 3", "2h 10m", R.drawable.portada5));
        lista_p.add(new PeliculasVo("Sonic La Pelicula", "1h 40m", R.drawable.portada6));
    }
    //Metodos para llenar los campos extras
    public void llenarDatosExtras(){
        lista_e.add(new PeliculasVo("Los Vengadores restantes deben encontrar una manera de recuperar a sus aliados para un enfrentamiento épico con Thanos, el malvado que diezmó el planeta y el universo.",
                "Joe Russo, Anthony Russo","Robert Downey Jr., Scarlett Johansson, Chris Hemsworth, Chris Evans",
                "7.4/10", "2.798 miles de millones USD"));
        lista_e.add(new PeliculasVo("David Dunn busca mantenerse un paso por delante de la ley mientras imparte justicia en las calles de Filadelfia. Sus talentos especiales pronto lo colocan en un curso de colisión con la Bestia, un loco psicótico que tiene una fuerza sobrehumana y 23 personalidades distintas.",
                "M. Night Shyamalan","James McAvoy, Bruce Willis, Samuel L. Jackson",
                "6.7/10", "247 millones USD"));
        lista_e.add(new PeliculasVo("Woody siempre ha tenido claro cuál es su labor en el mundo y cuál es su prioridad: cuidar a su dueño, ya sea Andy o Bonnie. Sin embargo, Woody descubrirá lo grande que puede ser el mundo para un juguete cuando Forky se convierta en su nuevo compañero de habitación.",
                "Josh Cooley","Tom Hanks, TimAllen, Keanu Reeves",
                "7.8/10", "1.073 miles de millones USD"));
        lista_e.add(new PeliculasVo("Aladdin es un ladronzuelo que se enamora de la hija del Sultán, la princesa Jasmine. Para poder conquistarla aceptará un desafío de Jafar. Aladdín tendrá que entrar en una cueva en mitad del desierto y conseguir una lámpara mágica que contiene al Genio que será el encargado de concederle todos sus deseos",
                "Guy Ritchie","Naomi Scott, Will Smith, Mena Massoud",
                "6.3/10", "1.051 miles de millones USD"));
        lista_e.add(new PeliculasVo("John Wick regresa de nuevo pero con una recompensa sobre su cabeza que persigue unos mercenarios. Tras asesinar a uno de los miembros de su gremio, Wick es expulsado y se convierte en el foco de atención de todos los sicarios de la organización.",
                "Chad Stahelski","Keanu Reeves, Halle Berry, Ian McShane, Asia Kate Dillon",
                "7.5/10", "329.7 millones USD"));
        lista_e.add(new PeliculasVo("Sonic intenta navegar por las complejidades de la vida en la Tierra con su nuevo mejor amigo, un humano llamado Tom Wachowski. Pronto deben unir fuerzas para evitar que el malvado Dr. Robotnik capture a Sonic y use sus poderes para dominar el mundo.",
                "Jeff Fowler","Jim arrey, James Marsden, Ben Schwartz",
                "5.6/10", "306.8 miles de millones USD"));


    }
}
