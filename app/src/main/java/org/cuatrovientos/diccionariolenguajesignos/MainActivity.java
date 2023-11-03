package org.cuatrovientos.diccionariolenguajesignos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import org.cuatrovientos.diccionariolenguajesignos.adapters.RecyclerDataAdapter;
import org.cuatrovientos.diccionariolenguajesignos.model.Categoria;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;

    RecyclerDataAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm realm = Realm.getDefaultInstance();


        realm.beginTransaction();


        Categoria saludosPreguntas = new Categoria("Saludos y Preguntas");
        Categoria familia = new Categoria("Familia");
        Categoria comidasBebidas = new Categoria("Comidas y Bebidas");
        Categoria ropa = new Categoria("Ropa");
        Categoria cuerpo = new Categoria("Cuerpo");
        Categoria casa = new Categoria("Casa");
        Categoria colegio = new Categoria("Colegio");
        Categoria ciudad = new Categoria("Ciudad");
        Categoria calendario = new Categoria("Calendario");
        Categoria naturaleza = new Categoria("Naturaleza");
        Categoria adjetivosAdverbiosVerbos = new Categoria("Adjetivos, Adverbios y Verbos");



        realm.copyToRealm(saludosPreguntas);
        realm.copyToRealm(familia);
        realm.copyToRealm(comidasBebidas);
        realm.copyToRealm(ropa);
        realm.copyToRealm(cuerpo);
        realm.copyToRealm(casa);
        realm.copyToRealm(colegio);
        realm.copyToRealm(ciudad);
        realm.copyToRealm(calendario);
        realm.copyToRealm(naturaleza);
        realm.copyToRealm(adjetivosAdverbiosVerbos);

        realm.commitTransaction();

        recycler = findViewById(R.id.recyclerCategorias);
        RealmResults<Categoria> categorias = realm.where(Categoria.class).findAll();
        adapter = new RecyclerDataAdapter(categorias, new RecyclerDataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Categoria categoria, int position) {
                Toast.makeText(MainActivity.this, "Position: "+position, Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new GridLayoutManager(this,2));


    }


}