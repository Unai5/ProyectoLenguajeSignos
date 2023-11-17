package org.cuatrovientos.diccionariolenguajesignos.model;

import org.cuatrovientos.diccionariolenguajesignos.app.MyAplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Categoria extends RealmObject {
    @PrimaryKey
    private int id;

    private String nombre;

    private String foto;

    public Categoria(){

    }
    public Categoria(String nombre, String foto){
        this.id= MyAplication.categoriaID.incrementAndGet();
        this.nombre=nombre;
        this.foto=foto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
