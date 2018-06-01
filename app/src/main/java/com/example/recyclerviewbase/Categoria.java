package com.example.recyclerviewbase;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Objects;

public class Categoria {

    private String nombreCategoria;
    private ArrayList<Pelicula> listadoPeliculas;

    public Categoria() {
        this.nombreCategoria = new String();
        this.listadoPeliculas = new ArrayList<>();
    }

    public Categoria(ArrayList<Pelicula> listadoPeliculas, String nombreCategoria) {
        this.listadoPeliculas=listadoPeliculas;
        this.nombreCategoria=nombreCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return listadoPeliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> listadoPeliculas) {
        listadoPeliculas = listadoPeliculas;
    }

    public void agregarPelicula(Pelicula pelicula){
        if(!this.listadoPeliculas.contains(pelicula)){
            listadoPeliculas.add(pelicula);
        }
    }

    public void removerPelicula(Pelicula pelicula){
        if(this.listadoPeliculas.contains(pelicula)){
            this.listadoPeliculas.remove(pelicula);
        }
    }

}
