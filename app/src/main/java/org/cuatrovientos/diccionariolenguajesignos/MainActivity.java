package org.cuatrovientos.diccionariolenguajesignos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import org.cuatrovientos.diccionariolenguajesignos.adapters.RecyclerDataAdapter;
import org.cuatrovientos.diccionariolenguajesignos.model.Categoria;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    RecyclerDataAdapter recyclerDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm realm = Realm.getDefaultInstance();


        Categoria saludosPreguntas = new Categoria("Saludos y Preguntas", "R.drawable.saludospreguntas");
        Categoria ropa = new Categoria("Ropa", "R.drawable.ropa");
        Categoria naturaleza = new Categoria("Naturaleza", "R.drawable.naturaleza");
        Categoria familia = new Categoria("Familia", "R.drawable.familia");
        Categoria cuerpo = new Categoria("Cuerpo", "R.drawable.cuerpo");
        Categoria comidasBebidas = new Categoria("Comidas y Bebidas", "R.drawable.comidasbebidas");
        Categoria colegio = new Categoria("Colegio", "R.drawable.colegiocategoria");
        Categoria ciudad = new Categoria("Ciudad", "R.drawable.ciudadcategoria");
        Categoria casa = new Categoria("Casa", "R.drawable.casacategoria");
        Categoria calendario = new Categoria("Calendario", "R.drawable.calendariocategoria");
        Categoria adjetivosAdverbiosVerbos = new Categoria("Adjetivos, Adverbios y Verbos", "R.drawable.adjetivosadverbiosverbos");

        RealmResults<Categoria> listaCategorias = realm.where(Categoria.class).findAll();

        if (listaCategorias.size()==0){

            realm.beginTransaction();

            realm.copyToRealm(saludosPreguntas);
            realm.copyToRealm(ropa);
            realm.copyToRealm(naturaleza);
            realm.copyToRealm(familia);
            realm.copyToRealm(cuerpo);
            realm.copyToRealm(comidasBebidas);
            realm.copyToRealm(colegio);
            realm.copyToRealm(ciudad);
            realm.copyToRealm(casa);
            realm.copyToRealm(calendario);
            realm.copyToRealm(adjetivosAdverbiosVerbos);

            realm.commitTransaction();

        }

        recycler = findViewById(R.id.recyclerCategorias);


        recyclerDataAdapter = new RecyclerDataAdapter(listaCategorias, new RecyclerDataAdapter.OnItemClickListener() {


            @Override
            public void onItemClick(Categoria categoria, int position) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                int id = categoria.getId();
                intent.putExtra("id", id);
                startActivity(intent);
            }


        });
        recycler.setAdapter(recyclerDataAdapter);
        recycler.setLayoutManager(new GridLayoutManager(this,1));


    }
}