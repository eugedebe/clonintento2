package com.example.recyclerviewbase;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.ArrayList;

public class AdapterDetalleCategoriaPageView extends FragmentStatePagerAdapter{

    //TODO: Paso 3 ViewPager. crear el adapter, que extiende de FragmentStatePagerAdapter

    //TODO: almaceno la lista de Fragments que el ViewPager mostrará
    private ArrayList<DetallePeliculaFragment> listadetallePeliculas;

    //TODO: este constructor necesita un FragmentManager, que le pasamos desde quien lo invoca con un getSupportFragmentManager(),
    // y recibe también la lista de Fragments

    public AdapterDetalleCategoriaPageView(FragmentManager fm, ArrayList<DetallePeliculaFragment> listadetallePeliculas) {
        super(fm);
        this.listadetallePeliculas = listadetallePeliculas;
    }

    @Override
    public Fragment getItem(int position) {
        return listadetallePeliculas.get(position);
    }

    @Override
    public int getCount() {
        return listadetallePeliculas.size();
    }

    //TODO: Paso 3 de TabLayout agrego este método para que el adapter pueda obtener los títulos de cada Fragment
    @Override
    public CharSequence getPageTitle(int position) {
        DetallePeliculaFragment detallePeliculaFragment = listadetallePeliculas.get(position);
        return detallePeliculaFragment.toString();

    }
}

