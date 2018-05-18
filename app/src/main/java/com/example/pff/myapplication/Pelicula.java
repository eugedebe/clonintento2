package com.example.pff.myapplication;

public class Pelicula {
    private String titulo;
    private int idAfiche;
    private String descripcion;

    public Pelicula (String titulo, int idAfiche, String descripcion){
        this.titulo = titulo;
        this.idAfiche = idAfiche;
        this.descripcion = descripcion;
    }

    public String getTitulo (){
        return titulo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getIdAfiche(){
        return idAfiche;
    }
}
