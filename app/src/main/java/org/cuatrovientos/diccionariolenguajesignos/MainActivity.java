package org.cuatrovientos.diccionariolenguajesignos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.cuatrovientos.diccionariolenguajesignos.model.Categoria;
import org.cuatrovientos.diccionariolenguajesignos.model.Palabra;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();

        Categoria familia = new Categoria("Familia",R.drawable.abuelo);
        Palabra abuelo = new Palabra("Abuelo" , R.drawable.abuelo , familia);


        realm.beginTransaction();
        realm.copyToRealm(abuelo);
        realm.commitTransaction();


    }
}