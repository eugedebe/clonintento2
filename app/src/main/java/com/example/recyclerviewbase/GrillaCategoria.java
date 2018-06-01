package com.example.recyclerviewbase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class GrillaCategoria extends AppCompatActivity {

    public static final String CLAVE_CATEGORIA = "categoria";
    private PeliculasFragment peliculasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //RECIBIR EL BUNDLE

        setContentView(R.layout.activity_grilla_categoria);

        Bundle bundle = getIntent().getExtras();

        //detallePeliculaFragment = new DetallePeliculaFragment();

         peliculasFragment = new PeliculasFragment();


        cargarFragment(peliculasFragment,bundle);
    }


    //EUGENIO: AGREGUE A LA FUNCIÓN DE CARGAR FRAGMENT LOS PARAMETROS ID DEL CONTAINER DE CADA
    // FRAGMENT Y EL TITULO DE CADA CATEGORÍA
    private void cargarFragment(PeliculasFragment peliculasFragment,Bundle bundle) {
       //EUGENIO: CARGO EL BUNDLE PARA ENVIAR EL TITULO DE LA CATEGORIA AL Fragment
        peliculasFragment.setArguments(bundle);
        ////////////////////////////////////////////////////////////////////////
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, peliculasFragment);
        fragmentTransaction.commit();
        //////////////////////////////////////////////////////////////
    }



    //@Override
    public void abrirGrilla(String categoria, ArrayList<Pelicula> peliculas) {

    }

    /*@Override
    public void solicituddeActualizarDatosFragmentsPelicula(Pelicula pelicula) {
        peliculasFragment.actualizarPelicula(pelicula);
    }
*/

}
