package com.example.recyclerviewbase;


import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnaCaegoriaViewPageFragment extends Fragment {


    public static final String CLAVE_CATEGORIAS = "nombre categoria";
    public static final String CLAVE_POSICION = "posicion pelicula seleccionada";
    Categoria categoria;
    int posicion;
    private FragmentActivity myContext;
    private ArrayList<DetallePeliculaFragment> listaDetallePeliculaFragment;

    private AdapterDetalleCategoriaPageView adapterDetalleCategoriaPageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_una_caegoria_view_page, container, false);
       recibirParametros();
       listaDetallePeliculaFragment = armarCadenaFragments(categoria);

//Encuentro el viewPager
        ViewPager viewPager =  (ViewPager)  view.findViewById(R.id.viewpager_unacat);
        //Creo el Adapter y le paso un fragment manager y la lista de fragments que mostrará
       adapterDetalleCategoriaPageView =
            new AdapterDetalleCategoriaPageView(getChildFragmentManager(), listaDetallePeliculaFragment);
        //Al viewPager le "presento" el adapter
        viewPager.setAdapter(adapterDetalleCategoriaPageView);
        // que el view pager comenzará en la posición deseada de la pelicula seleccionada
        viewPager.setCurrentItem(posicion);
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin(12);
        return view;

    }

    ArrayList<DetallePeliculaFragment> armarCadenaFragments(Categoria categoria) {
        ArrayList<DetallePeliculaFragment> listaDetallePeliculaFragment = new ArrayList<>();

        for (Pelicula peliculaActual : categoria.getPeliculas()) {
            listaDetallePeliculaFragment.add(DetallePeliculaFragment.DameUnFragmentDetallePelicula
                    (peliculaActual, categoria.getNombreCategoria()));
        }
        return listaDetallePeliculaFragment;
    }


    private void recibirParametros(){


            Bundle bundle = getArguments();

            if (bundle != null) {
                categoria = (Categoria) bundle.getSerializable(CLAVE_CATEGORIAS);
                posicion = bundle.getInt(CLAVE_POSICION);

            }

        }




}
