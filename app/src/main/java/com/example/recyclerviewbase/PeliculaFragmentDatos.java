package com.example.recyclerviewbase;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

public class PeliculaFragmentDatos {

    private RecyclerView recyclerView;
    private List<Pelicula> peliculas;
    private String stringTituloCategoria;

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public String getStringTituloCategoria() {
        return stringTituloCategoria;
    }

    public PeliculaFragmentDatos(RecyclerView recyclerView, List<Pelicula> peliculas, String stringTituloCategoria) {
        this.recyclerView = recyclerView;
        this.peliculas = peliculas;
        this.stringTituloCategoria = stringTituloCategoria;



    }
}
