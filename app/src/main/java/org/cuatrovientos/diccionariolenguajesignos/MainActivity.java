package org.cuatrovientos.diccionariolenguajesignos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.cuatrovientos.diccionariolenguajesignos.R;
import org.cuatrovientos.diccionariolenguajesignos.adapters.RecyclerDataAdapter;
import org.cuatrovientos.diccionariolenguajesignos.model.Categoria;

import java.util.ArrayList;
import java.util.List;

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


        Categoria saludosPreguntas = new Categoria("Saludos y Preguntas");
        Categoria ropa = new Categoria("Ropa");
        Categoria naturaleza = new Categoria("Naturaleza");
        Categoria familia = new Categoria("Familia");
        Categoria cuerpo = new Categoria("Cuerpo");
        Categoria comidasBebidas = new Categoria("Comidas y Bebidas");
        Categoria colegio = new Categoria("Colegio");
        Categoria ciudad = new Categoria("Ciudad");
        Categoria casa = new Categoria("Casa");
        Categoria calendario = new Categoria("Calendario");
        Categoria adjetivosAdverbiosVerbos = new Categoria("Adjetivos, Adverbios y Verbos");

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
        recycler.setLayoutManager(new GridLayoutManager(this,2));


    }
}