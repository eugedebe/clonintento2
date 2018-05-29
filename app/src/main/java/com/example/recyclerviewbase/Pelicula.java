package com.example.recyclerviewbase;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by ma on 21/05/18.
 */

//PARA PASAR UN OBJETO POR BUNDLE, TENGO QUE PONERLE IMPLEMENTS SERIALIZABLE EN SU CLASE
public class Pelicula implements Serializable {
    private String nombre;
    private int imageRes;
    private String descripcion;
    private Boolean estaFavorito;
    private Integer idPelicula;




    public Pelicula(String nombre, int imageRes) {
        this.nombre = nombre;
        this.imageRes = imageRes;
    }


    public Pelicula(String nombre) {
        this.nombre = nombre;
        this.imageRes = R.drawable.santa;
    }

    public Pelicula(String nombre, String descripcion) {
        this.nombre = nombre;
        this.imageRes = R.drawable.santa;
        this.descripcion = descripcion;
    }
    public Pelicula(String nombre, String descripcion, int imageRes) {
        this.nombre = nombre;
        this.imageRes = imageRes;
        this.descripcion = descripcion;
        this.estaFavorito = false;


    }
    public Pelicula(String nombre, String descripcion, int imageRes, Boolean estaFavorito,Integer idPelicula) {
        this.nombre = nombre;
        this.imageRes = imageRes;
        this.descripcion = descripcion;
        this.estaFavorito = estaFavorito;
        this.idPelicula = idPelicula;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return idPelicula.equals(pelicula.idPelicula);
    }


    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Boolean getEstaFavorito() { return estaFavorito; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setEstaFavorito(Boolean estado) { this.estaFavorito = estado;}

    public void cambiarEstadoFav (){ this.estaFavorito=!this.estaFavorito; }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
