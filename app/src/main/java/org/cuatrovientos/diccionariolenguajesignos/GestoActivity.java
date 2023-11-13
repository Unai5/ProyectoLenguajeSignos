package org.cuatrovientos.diccionariolenguajesignos;

import androidx.appcompat.app.AppCompatActivity;

import android.location.GnssAntennaInfo;
import android.os.Bundle;

import org.cuatrovientos.diccionariolenguajesignos.R;
import org.cuatrovientos.diccionariolenguajesignos.adapters.RecyclerDataAdapter;
import org.cuatrovientos.diccionariolenguajesignos.adapters.RecyclerPalabraAdapter;

import android.content.Intent;

import android.widget.Button;

public class GestoActivity extends AppCompatActivity {
    Button buttonVolver = findViewById(R.id.buttonVolver);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesto);


        buttonVolver.setOnClickListener(v -> {
            Intent intent = new Intent(GestoActivity.this, MainActivity.class);
            startActivity(intent);
        });



    }


}