package org.cuatrovientos.diccionariolenguajesignos.model;


import org.cuatrovientos.diccionariolenguajesignos.app.MyAplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Palabra extends RealmObject{
    @PrimaryKey
    private int id;
    private String palabra;

    private Integer imagen;

    private Categoria categoria;

    public Palabra(){

    }
    public Palabra(String palabra , Integer imagen , Categoria categoria){
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }
}
