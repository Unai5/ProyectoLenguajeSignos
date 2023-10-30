package org.cuatrovientos.diccionariolenguajesignos.model;


import org.cuatrovientos.diccionariolenguajesignos.app.MyAplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Palabra extends RealmObject{
    @PrimaryKey
    private int id;
    private String palabra;
    private Integer imagen;
    private String categoria;

    public Palabra(String palabra , Integer imagen , String categoria){
        this.id= MyAplication.palabraID.incrementAndGet();
        this.palabra=palabra;
        this.imagen=imagen;
        this.categoria=categoria;
    }

    public String getPalabra() {
        return palabra;
    }

    public Integer getImagen() {
        return imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
