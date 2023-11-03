package org.cuatrovientos.diccionariolenguajesignos.model;

import org.cuatrovientos.diccionariolenguajesignos.app.MyAplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;


public class Categoria extends RealmObject {
    @PrimaryKey
    private int id;
    @Required
    private String nombre;


    public Categoria(){

    }
    public Categoria(String nombre){
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
