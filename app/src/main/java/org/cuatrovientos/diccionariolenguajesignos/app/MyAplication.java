package org.cuatrovientos.diccionariolenguajesignos.app;

import android.app.Application;


import org.cuatrovientos.diccionariolenguajesignos.model.Categoria;
import org.cuatrovientos.diccionariolenguajesignos.model.Palabra;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyAplication extends Application {
    public static AtomicInteger palabraID = new AtomicInteger();
    public static AtomicInteger categoriaID = new AtomicInteger();
    @Override
    public void onCreate() {
        super.onCreate();

        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        palabraID = getIdByTable(realm, Palabra.class);
        categoriaID=getIdByTable(realm , Categoria.class);
        realm.close();
    }
    private void setUpRealmConfig(){
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass) {

        RealmResults<T> results = realm.where(anyClass).findAll();

        if (results.size() > 0) {
            return new AtomicInteger(results.max("id").intValue());
        } else {
            return new AtomicInteger(0);
        }
    }
}

