package com.example.recyclerviewbase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatosIniciales {

private ArrayList<Pelicula> peliculas,listaFavoritos;
private int clavesPeliculas=0;
private ArrayList<String> listaCategorias;

    public DatosIniciales(){
        this.peliculas=armarListadoPeliculas();
        this.listaFavoritos = entregarListaFavoritos();
        this.listaCategorias = entregarListaCategorías();

    }


    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public ArrayList<Pelicula> getListafavoritos() {
        return listaFavoritos;
    }

    public ArrayList<String> getListaCategorias() {
        return listaCategorias;
    }



    public void setListafavoritos(ArrayList<Pelicula> listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
    }

    private ArrayList<Pelicula> armarListadoPeliculas() {
        peliculas = new ArrayList<>();

        Pelicula pelicula = new Pelicula("Batman - El Caballero Oscuro",
                "Acción, Drama, Crimen", R.drawable.caballero2, true, clavesPeliculas++);
        peliculas.add(pelicula);

        pelicula = new Pelicula("El Padrino",
                "Crimen, Drama", R.drawable.padrino, false, clavesPeliculas++);
        peliculas.add(pelicula);

        pelicula = new Pelicula("Tiempos Violentos",
                "Accion, Drama, Crimen", R.drawable.pulp, true, clavesPeliculas++);
        peliculas.add(pelicula);

        pelicula = new Pelicula("El Profesional",
                "Crimen, Drama", R.drawable.elprofesional, false, clavesPeliculas++);
        peliculas.add(pelicula);

        pelicula = new Pelicula("El Señor de los Anillos",
                "Aventura, Fantasia", R.drawable.lordof, false, clavesPeliculas++);
        peliculas.add(pelicula);



        pelicula = new Pelicula("Star Wars",
                "Ciencia Ficción", R.drawable.starwars, false, clavesPeliculas++);
        peliculas.add(pelicula);


        pelicula = new Pelicula("Matrix",
                "Ciencia Ficción", R.drawable.matrix, true, clavesPeliculas++);
        peliculas.add(pelicula);


        pelicula = new Pelicula("Origen",
                "Ciencia Ficción", R.drawable.origen, false, clavesPeliculas++);
        peliculas.add(pelicula);


        pelicula = new Pelicula("Forrest Gump",
                "Drama", R.drawable.forrest, false, clavesPeliculas++);
        peliculas.add(pelicula);


        return peliculas;
    }

    private  ArrayList<Pelicula> entregarListaFavoritos(){
        listaFavoritos = new ArrayList<>();
        for (Pelicula peliculaActual : peliculas) {
            if (peliculaActual.getEstaFavorito()) {
                listaFavoritos.add(peliculaActual);
            }
        }
        return listaFavoritos;
    }

    private ArrayList<String> entregarListaCategorías(){
        ArrayList<String> listaCategorias = new ArrayList<>();
        int i=0;
        for(i=0;i<5;i++)
        {
            listaCategorias.add("Cat: "+i);
        }
        return listaCategorias;
    }

    public void agregaraFavoritos(Pelicula pelicula){
        if(!this.listaFavoritos.contains(pelicula)){
            this.listaFavoritos.add(pelicula);
        }
    }
    public void removerFavoritos(Pelicula pelicula){
        if(this.listaFavoritos.contains(pelicula)){
           this.listaFavoritos.remove(pelicula);
        }
    }


}


