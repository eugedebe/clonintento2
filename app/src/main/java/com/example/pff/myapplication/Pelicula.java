package com.example.pff.myapplication;

public class Pelicula {
    //atributos
    private String titulo;
    private int idAfiche;
    private String descripcion;
//constructor
    public Pelicula (String titulo, String descripcion, int idAfiche){
        this.titulo = titulo;
        this.idAfiche = idAfiche;
        this.descripcion = descripcion;
    }
//getters
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
