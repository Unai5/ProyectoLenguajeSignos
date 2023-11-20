package org.cuatrovientos.diccionariolenguajesignos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.cuatrovientos.diccionariolenguajesignos.model.Palabra;

import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import io.realm.Realm;

public class GestoActivity extends AppCompatActivity {

    ImageView imgView;

    TextView txtNombreGesto, txtCategoria;
    Button buttonVolver ;
    Realm realm;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesto);
        realm = Realm.getDefaultInstance();
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        Palabra palabra = realm.where(Palabra.class).equalTo("id",id).findFirst();

        imgView = findViewById(R.id.imgPalabra);
        txtNombreGesto = findViewById(R.id.textViewPalabra);
        txtCategoria = findViewById(R.id.textViewCategoria);
        buttonVolver = findViewById(R.id.buttonVolver);
        intent = new Intent(GestoActivity.this, SecondActivity.class);

        txtNombreGesto.setText(palabra.getPalabra());
        txtCategoria.setText(palabra.getCategoria().getNombre());
        imgView.setImageResource(palabra.getImagen());

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        }   );


    }


}