package org.cuatrovientos.diccionariolenguajesignos.model;

import org.cuatrovientos.diccionariolenguajesignos.app.MyAplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Categoria extends RealmObject {
    @PrimaryKey
    private int id;
    private String nombre;

    private Categoria(String nombre){
        this.id= MyAplication.categoriaID.incrementAndGet();
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
