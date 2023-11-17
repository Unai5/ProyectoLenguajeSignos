package org.cuatrovientos.diccionariolenguajesignos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.cuatrovientos.diccionariolenguajesignos.adapters.RecyclerPalabraAdapter;
import org.cuatrovientos.diccionariolenguajesignos.model.Categoria;
import org.cuatrovientos.diccionariolenguajesignos.model.Palabra;

import java.lang.reflect.Field;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class SecondActivity extends AppCompatActivity {
    Realm realm;
    RealmResults<Palabra> results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        realm = Realm.getDefaultInstance();

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        Categoria categoria = realm.where(Categoria.class).equalTo("id",id).findFirst();


        
        results=realm.where(Palabra.class).equalTo("categoria.id",id).findAll();


        RecyclerView recyclerView;
        recyclerView=(RecyclerView) findViewById(R.id.recyclePalabra);

        
        
        
        RecyclerPalabraAdapter recyclerDataAdapter = new RecyclerPalabraAdapter(this,results, new RecyclerPalabraAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(String name, int id, int imageResource) {
                Intent intent = new Intent(SecondActivity.this, GestoActivity.class);



                intent.putExtra("id", id);

                startActivity(intent);
            }

        });
        recyclerView.setAdapter(recyclerDataAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


    }
}