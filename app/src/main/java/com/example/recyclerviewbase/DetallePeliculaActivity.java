package com.example.recyclerviewbase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class DetallePeliculaActivity extends AppCompatActivity  {

    private DetallePeliculaFragment detallePeliculaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);
        Bundle bundle = getIntent().getExtras();
        detallePeliculaFragment = new DetallePeliculaFragment();
        detallePeliculaFragment.setArguments(bundle);
        cargarFragment(detallePeliculaFragment);

    }


    private void cargarFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment1, fragment);
        fragmentTransaction.commit();
    }

  public void abrirGrilla(String categoria, ArrayList<Pelicula> peliculas){

    }


}
