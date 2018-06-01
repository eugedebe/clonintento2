package com.example.recyclerviewbase;

import java.io.Serializable;
import java.util.Objects;


public class CategoriaRecycleViewFragment implements Serializable {
    Boolean GrillaActiva;
    Categoria categoria;

    public CategoriaRecycleViewFragment() {
        GrillaActiva = false;
        this.categoria = new Categoria();
    }



    public CategoriaRecycleViewFragment(Categoria categoria, Boolean grillaActiva ) {
        GrillaActiva = grillaActiva;
        this.categoria = categoria;
    }

    public Boolean getGrillaActiva() {
        return GrillaActiva;
    }

    public void setGrillaActiva(Boolean grillaActiva) {
        GrillaActiva = grillaActiva;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
