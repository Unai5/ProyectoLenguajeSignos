package org.cuatrovientos.diccionariolenguajesignos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.cuatrovientos.diccionariolenguajesignos.adapters.RecyclerPalabraAdapter;
import org.cuatrovientos.diccionariolenguajesignos.model.Categoria;
import org.cuatrovientos.diccionariolenguajesignos.model.Palabra;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class SecondActivity extends AppCompatActivity {
    Realm realm;
    RealmResults<Palabra> results;
    RecyclerPalabraAdapter recyclerDataAdapter;
    RecyclerView recyclerView;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        realm = Realm.getDefaultInstance();
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        Categoria categoria = realm.where(Categoria.class).equalTo("id",id).findFirst();


        
        results=realm.where(Palabra.class).equalTo("categoria.id",id).findAll();



        recyclerView=(RecyclerView) findViewById(R.id.recyclePalabra);

        
        
        
         recyclerDataAdapter = new RecyclerPalabraAdapter(this,results, new RecyclerPalabraAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int id) {
                Intent intent = new Intent(SecondActivity.this, GestoActivity.class);



                intent.putExtra("id", id);

                startActivity(intent);
            }

        });
        recyclerView.setAdapter(recyclerDataAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


    }

    private void filterList(String text) {
        List<Palabra> filteredList = new ArrayList<>();
        for (Palabra item : results) {
            if (item.getPalabra().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        if (filteredList.isEmpty()){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

    }else{
            recyclerDataAdapter.setFilteredList(filteredList);
        }
}
}