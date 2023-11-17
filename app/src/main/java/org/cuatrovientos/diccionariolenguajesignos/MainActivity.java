package org.cuatrovientos.diccionariolenguajesignos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import org.cuatrovientos.diccionariolenguajesignos.adapters.RecyclerDataAdapter;
import org.cuatrovientos.diccionariolenguajesignos.model.Categoria;
import org.cuatrovientos.diccionariolenguajesignos.model.Palabra;

import java.lang.reflect.Field;
import java.util.ArrayList;

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


        Categoria saludosPreguntas = new Categoria("Saludos y Preguntas", R.drawable.saludospreguntas, "saludospreguntas");
        Categoria ropa = new Categoria("Ropa", R.drawable.ropa, "ropa");
        Categoria naturaleza = new Categoria("Naturaleza", R.drawable.naturaleza, "naturaleza");
        Categoria familia = new Categoria("Familia", R.drawable.familia, "familia");
        Categoria cuerpo = new Categoria("Cuerpo", R.drawable.cuerpocategoria, "cuerpo");
        Categoria comidasBebidas = new Categoria("Comidas y Bebidas", R.drawable.comidasbebidas, "comidasbebidas");
        Categoria colegio = new Categoria("Colegio", R.drawable.colegiocategoria, "colegio");
        Categoria ciudad = new Categoria("Ciudad", R.drawable.ciudadcategoria, "ciudad");
        Categoria casa = new Categoria("Casa", R.drawable.casacategoria, "casa");
        Categoria calendario = new Categoria("Calendario", R.drawable.calendariocategoria, "calendario");
        Categoria adjetivosAdverbiosVerbos = new Categoria("Adjetivos, Adverbios y Verbos", R.drawable.adjetivosadverbiosverbos, "adjetivosadverbiosverbos");

        RealmResults<Categoria> listaCategorias = realm.where(Categoria.class).findAll();

        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();

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

            Field[] drawables = R.drawable.class.getFields();
            for (Field f : drawables) {
                try {
                    String[] parts = f.getName().split("_");
                    int resourceId = this.getResources().getIdentifier(f.getName(), "drawable", this.getPackageName());
                    String nombrePalabra = "";
                    for (int i = 0; i < parts.length; i++) {
                        if (i>0){
                            if (i< parts.length-2){
                                nombrePalabra = nombrePalabra + parts[i] +" ";
                            }else{
                                nombrePalabra = nombrePalabra + parts[i];
                            }
                        }
                    }
                    realm.copyToRealm(new Palabra(nombrePalabra, resourceId, realm.where(Categoria.class).equalTo("nombreFoto", parts[0]).findFirst()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            realm.commitTransaction();

        }

        recycler = findViewById(R.id.recyclerCategorias);

        listaCategorias = realm.where(Categoria.class).findAll();

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