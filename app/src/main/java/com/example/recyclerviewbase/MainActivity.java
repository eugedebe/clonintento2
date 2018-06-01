package com.example.recyclerviewbase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PeliculasFragment.NotificadorPelicula, BarraExplorar.NotificadorBarraExplorar {


    private BarraExplorar barraExplorar;
    private TodasCategoriasFragment todasCategoriasfragment;
    private ArrayList<Pelicula> peliculasCategoría;
    public static final DatosIniciales datosIniciales = new DatosIniciales();
    private ArrayList<Categoria> listadoCategorias;
    private int idContenedorFragments;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Cargo el fragment categorías
        todasCategoriasfragment = new TodasCategoriasFragment();
        listadoCategorias = new ArrayList<>();
        idContenedorFragments = R.id.contenedor_Fragments;

        //Simulo recibir categoría
        //cargo categoría 1

        listadoCategorias = recibirListadoPeliculasXCategoria();
        cargarCategoriaN(todasCategoriasfragment, listadoCategorias, idContenedorFragments);
        //CARGO LA BARRA EXPLORAR
        cargarBarra();
    }

//ESTA FUNCION SIMULA RECIBIR EL LISTADO DE PELICULAS DESDE LA APPI, DEBE ENTREGAR UN LISTADO DE
    //TODAS LAS PELICULAS ORGANIZADAS POR CATEGORIAS QUE DEFINIMOS VER
    private ArrayList<Categoria> recibirListadoPeliculasXCategoria() {
           int i;
        ArrayList<Categoria> listadoCategorias = new ArrayList<>();
            for(i=1;i<7;i++)

        {
            Categoria categoria = new Categoria(datosIniciales.getPeliculas(), "Categoria " + i);
            listadoCategorias.add(categoria);
        }
        return listadoCategorias;
    }

    private void cargarBarra() {

        barraExplorar = new BarraExplorar();
        int idContanerBarra = R.id.barra_favorito_id;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(idContanerBarra, barraExplorar);
        fragmentTransaction.commit();

    }


    private void cargarCategoriaN(TodasCategoriasFragment todasCategoriasfragment,
                                  ArrayList<Categoria> listadoCategorias,int idContenedor) {


        Bundle unBundle = new Bundle();
        unBundle.putSerializable(todasCategoriasfragment.CLAVE_TODAS_CATEGORIAS, (Serializable)  listadoCategorias);
        todasCategoriasfragment.setArguments(unBundle);
        //INICIO LA ACTIVIDAD
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(idContenedor, todasCategoriasfragment);
        fragmentTransaction.addToBackStack(todasCategoriasfragment.getClass().getName());
        fragmentTransaction.commit();
    }







    @Override
    public void notificar(Pelicula pelicula) {
        //SI QUEREMOS HACERLO DESDE UNA NUEVA ACTIVITY DEBERÍA QUEDAR ESTA
        /*Intent intent = new Intent(this,DetallePeliculaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetallePeliculaFragment.PELICULA_KEY, pelicula);
        intent.putExtras(bundle);
        startActivity(intent);
        */
        DetallePeliculaFragment detallePeliculaFragment = new DetallePeliculaFragment();
        Bundle unBundle = new Bundle();
        unBundle.putSerializable(DetallePeliculaFragment.PELICULA_KEY,pelicula);
        detallePeliculaFragment.setArguments(unBundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(idContenedorFragments, detallePeliculaFragment);
        fragmentTransaction.addToBackStack(detallePeliculaFragment.getClass().getName());
        fragmentTransaction.commit();



    }

    @Override
    public void abrirGrilla(CategoriaRecycleViewFragment categoria){
        //CARGO EL BUNDLE PARA Enviar al fragment
        CategoriaRecycleViewFragment categoriaAbrir = new CategoriaRecycleViewFragment(categoria.getCategoria(),true);
        PeliculasFragment peliculasFragment = new PeliculasFragment();
        Bundle unBundle = new Bundle();
        unBundle.putSerializable(PeliculasFragment.CLAVE_CATEGORIA, categoriaAbrir);
        peliculasFragment.setArguments(unBundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(idContenedorFragments, peliculasFragment);
        fragmentTransaction.addToBackStack(peliculasFragment.getClass().getName());
        fragmentTransaction.commit();

    }

    @Override
    public void solicituddeActualizarDatosFragmentsPelicula(Pelicula pelicula) {

        todasCategoriasfragment.actualizarPelicula(pelicula);
        if(pelicula.getEstaFavorito()){
            datosIniciales.agregaraFavoritos(pelicula);
        }else{
            datosIniciales.removerFavoritos(pelicula);
        }
    }





    @Override
    public void abrirFavoritos() {

        Categoria categoria =  new Categoria (datosIniciales.getListafavoritos(),"Favoritos") ;
        CategoriaRecycleViewFragment categoriaRecycleFavoritos = new CategoriaRecycleViewFragment(categoria,true);
        abrirGrilla(categoriaRecycleFavoritos);
        /*
        Intent unIntent = new Intent(this, GrillaCategoria.class);
        //CARGO EL BUNDLE PARA ENVIAR AL ACTIVITY
        Bundle unBundle = new Bundle();
        unBundle.putString(PeliculasFragment.CLAVE_CATEGORIA, "Favoritos");
        unBundle.putBoolean(PeliculasFragment.CLAVE_ACTIVAR_GRILLA, true);
        //ASOCIO EL BUNDLE AL INTENT
        unIntent.putExtras(unBundle);
        //COMIENZO LA ACTIVIDAD
        startActivity(unIntent);
*/

    }

    @Override
    public void abrirHome() {
        cargarCategoriaN(todasCategoriasfragment, listadoCategorias, idContenedorFragments);
    }


}


