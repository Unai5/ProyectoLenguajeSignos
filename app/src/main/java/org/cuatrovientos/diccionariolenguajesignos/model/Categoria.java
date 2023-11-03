package org.cuatrovientos.diccionariolenguajesignos.model;

import org.cuatrovientos.diccionariolenguajesignos.app.MyAplication;


public class Categoria extends RealmObject {
    @PrimaryKey
    private int id;
    @Required
    private String nombre;
    @Required
    private int foto;

    private Categoria(String nombre , int foto){
        this.id= MyAplication.categoriaID.incrementAndGet();
        this.nombre=nombre;
        this.foto=foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
