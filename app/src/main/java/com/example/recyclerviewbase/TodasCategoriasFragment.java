package com.example.recyclerviewbase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;




/**
 * A simple {@link Fragment} subclass.
 */
public class TodasCategoriasFragment extends Fragment  {
//implements PeliculasFragment.NotificarEntreFragment


    private ArrayList<PeliculasFragment> listaPeliculasFragment;
    private ArrayList<Categoria> listadoCategorias;
    public static final String CLAVE_TODAS_CATEGORIAS = "nombreCatpeliculas";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.todascategoriasfragment, container, false);
        //variables

        listaPeliculasFragment= new ArrayList<>();
        listadoCategorias = recibirCategorias(); //carga el listado de peliculas ordenados según categorias
        CategoriaRecycleViewFragment categoriaAEnviar;
        int idContainer;
        for(Categoria categoriaActual:listadoCategorias) {
            categoriaAEnviar = new CategoriaRecycleViewFragment(categoriaActual,false);
            idContainer = encontraContainer(categoriaActual.getNombreCategoria());
            cargarFragment(categoriaAEnviar, idContainer);
        }
        //EUGENIO: CARGO 6 CATEGORÍAS GENERICAS
        return view;
    }


    //EUGENIO: Cargo Fragment CATEGORIA
    private void cargarFragment(CategoriaRecycleViewFragment categoria,int idContainer) {

        PeliculasFragment peliculasFragment = new PeliculasFragment();
        listaPeliculasFragment.add(peliculasFragment);
        Bundle unBundle = new Bundle();
        unBundle.putSerializable(PeliculasFragment.CLAVE_CATEGORIA, categoria);
        peliculasFragment.setArguments(unBundle);
        ////////////////////////////////////////////////////////////////////////
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(idContainer, peliculasFragment);
        fragmentTransaction.commit();

    }

    //EUGENIO: RECIBO CATEGORIA

    private ArrayList<Categoria> recibirCategorias() {//Eugenio Recibo bundle


    ArrayList<Categoria> listadoCategorias = new ArrayList<>();
        Bundle bundle = getArguments();

        if (bundle != null) {
            listadoCategorias = (ArrayList) bundle.getSerializable(CLAVE_TODAS_CATEGORIAS);

        }
    return listadoCategorias;
    }

     int encontraContainer (String categoria) {

         if (categoria.equals("Categoria 1")) {
             return(R.id.container_fragment1);
         }
         else if (categoria.equals("Categoria 2")) {
             return (R.id.container_fragment2);
         }
         else if (categoria.equals("Categoria 3")) {
             return(R.id.container_fragment3);
         }
         else if (categoria.equals("Categoria 4")) {
             return(R.id.container_fragment4);
         }
         else if (categoria.equals("Categoria 5")) {
             return(R.id.container_fragment5);
         }
         else if (categoria.equals("Categoria 6")) {
             return(R.id.container_fragment6);

         }
         return -1;
     }




    void actualizarPelicula(Pelicula pelicula) {
        for (PeliculasFragment peliculasFragmentActual : listaPeliculasFragment) {
            if (peliculasFragmentActual.getListadoPeliculas().contains(pelicula)) {
                peliculasFragmentActual.actualizarPelicula(pelicula);
            }
        }
    }

}



