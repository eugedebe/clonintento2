package com.example.recyclerviewbase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PeliculasFragment.NotificadorPelicula,BarraExplorar.NotificadorBarraExplorar {

   private ArrayList<PeliculasFragment> lista_peliculasFragment;
    private PeliculasFragment peliculasFragment;
    private BarraExplorar barraExplorar;
    private String nombreCategoria;
    private int idCategoria,idCategoria2;
    private Boolean estado_Grilla;
    public static final DatosIniciales datosIniciales = new DatosIniciales();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista_peliculasFragment= new ArrayList<>();

        //EUGENIO: CARGO 6 CATEGORÍAS GENERICAS
        peliculasFragment = new PeliculasFragment();
        estado_Grilla=false;
        nombreCategoria = new String("Populares");
        idCategoria=R.id.container_fragment1;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria,estado_Grilla);
        lista_peliculasFragment.add(peliculasFragment);

        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Cat2");
        idCategoria2=R.id.container_fragment2;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria2,estado_Grilla);
        lista_peliculasFragment.add(peliculasFragment);

        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Cat3");
        idCategoria=R.id.container_fragment3;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria,estado_Grilla);
        lista_peliculasFragment.add(peliculasFragment);

        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Cat4");
        idCategoria=R.id.container_fragment4;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria,estado_Grilla);
        lista_peliculasFragment.add(peliculasFragment);

        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Cat5");
        idCategoria=R.id.container_fragment5;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria,estado_Grilla);
        lista_peliculasFragment.add(peliculasFragment);


        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Cat6");
        idCategoria=R.id.container_fragment6;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria,estado_Grilla);
        lista_peliculasFragment.add(peliculasFragment);


        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Cat6");
        idCategoria=R.id.container_fragment6;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria,estado_Grilla);
        lista_peliculasFragment.add(peliculasFragment);

        //CARGO LA BARRA EXPLORAR
        barraExplorar = new BarraExplorar();
        int idContanerBarra = R.id.barra_favorito_id;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(idContanerBarra, barraExplorar);
        fragmentTransaction.commit();

    }


 /*   protected void onRestart() {

        super.onRestart();
        CharSequence text = "OnRestart";
        solicituddeActualizarDatosFragmentsPelicula();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();


    }
*/

  /*protected void onRestart() {

        super.onRestart();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();

    }*/

    protected void onResume() {

        super.onResume();
        CharSequence text = "OnResume!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();

    }


    //EUGENIO: AGREGUE A LA FUNCIÓN DE CARGAR FRAGMENT LOS PARAMETROS ID DEL CONTAINER DE CADA
    // FRAGMENT Y EL TITULO DE CADA CATEGORÍA
    private void cargarFragment(Fragment fragment,String Categoria,int IdCategoria,Boolean estadoGrilla) {


        //EUGENIO: CARGO EL BUNDLE PARA ENVIAR EL TITULO DE LA CATEGORIA AL Fragment


        Bundle unBundle = new Bundle();
        unBundle.putString(PeliculasFragment.CLAVE_TITULO_CATEGORIA, Categoria);
        unBundle.putBoolean(PeliculasFragment.CLAVE_ACTIVAR_GRILLA, estadoGrilla);
        unBundle.putSerializable(PeliculasFragment.CLAVE_PELICULAS, (Serializable) MainActivity.datosIniciales.getPeliculas());
        peliculasFragment.setArguments(unBundle);
        ////////////////////////////////////////////////////////////////////////

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(IdCategoria, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void notificar(Pelicula pelicula) {
        Intent intent = new Intent(this,DetallePeliculaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetallePeliculaFragment.PELICULA_KEY, pelicula);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void abrirGrilla(String categoria, ArrayList<Pelicula> peliculas){
        //IR A LA Activity de detalle de categoría en grilla
        Intent unIntent = new Intent(this, GrillaCategoria.class);
        //CARGO EL BUNDLE PARA ENVIAR AL ACTIVITY
        Bundle unBundle = new Bundle();
        unBundle.putString(PeliculasFragment.CLAVE_TITULO_CATEGORIA, categoria);
        unBundle.putBoolean(PeliculasFragment.CLAVE_ACTIVAR_GRILLA, true);
        unBundle.putSerializable(PeliculasFragment.CLAVE_PELICULAS, (Serializable) peliculas);
        //ASOCIO EL BUNDLE AL INTENT
        unIntent.putExtras(unBundle);
        //COMIENZO LA ACTIVIDAD
        startActivity(unIntent);
    }


    @Override
    public void solicituddeActualizarDatosFragmentsPelicula(Pelicula pelicula){
        for(PeliculasFragment fragmentActual: lista_peliculasFragment ){
            fragmentActual.actualizarPelicula(pelicula);

        }
    }



    @Override
    public void abrirFavoritos() {
        Intent unIntent = new Intent(this, GrillaCategoria.class);
        //CARGO EL BUNDLE PARA ENVIAR AL ACTIVITY
        Bundle unBundle = new Bundle();
        unBundle.putString(PeliculasFragment.CLAVE_TITULO_CATEGORIA, "Favoritos");
        unBundle.putBoolean(PeliculasFragment.CLAVE_ACTIVAR_GRILLA, true);
        unBundle.putSerializable(PeliculasFragment.CLAVE_PELICULAS, (Serializable) this.datosIniciales.getListafavoritos());
        //ASOCIO EL BUNDLE AL INTENT
        unIntent.putExtras(unBundle);
        //COMIENZO LA ACTIVIDAD
        startActivity(unIntent);


    }



}


