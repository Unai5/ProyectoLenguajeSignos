package org.cuatrovientos.diccionariolenguajesignos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.cuatrovientos.diccionariolenguajesignos.adapters.RecyclerPalabraAdapter;
import org.cuatrovientos.diccionariolenguajesignos.model.Palabra;

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




        results=realm.where(Palabra.class).findAll();


        RecyclerView recyclerView;
        recyclerView=(RecyclerView) findViewById(R.id.recyclePalabra);

        Context context = this;
        RecyclerPalabraAdapter recyclerDataAdapter = new RecyclerPalabraAdapter(this,results, new RecyclerPalabraAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(String name, int position, int imageResource) {
                Intent intent = new Intent(SecondActivity.this, SecondActivity.class);



                intent.putExtra("pos", position);

                startActivity(intent);
            }

        });
        recyclerView.setAdapter(recyclerDataAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


    }
}