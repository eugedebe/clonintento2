package com.example.recyclerviewbase;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.io.Serializable;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class PeliculasFragment extends Fragment implements PeliculaAdapter.NotificadorPeliculaCelda {

    private RecyclerView recyclerView;
 //   private ArrayList<Pelicula> listadoPeliculas;

    private NotificadorPelicula notificadorPelicula;
    //private NotificarEntreFragment notificadorEntreFragment;
    private PeliculaAdapter adapter;
    private TextView textTituloCategoria;
    private CategoriaRecycleViewFragment categoriaACargar;

    public static final String CLAVE_CATEGORIA = "categoria";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_peliculas, container, false);
        //llamamos a la función que implementa la interfaz
      //  onAttachToParentFragment(getParentFragment());
        recyclerView = view.findViewById(R.id.recycler_id);
        textTituloCategoria = (TextView) view.findViewById(R.id.nombreCategoria);
        categoriaACargar=recibirCategoriaACargar(view);
        cargarContainer(categoriaACargar,textTituloCategoria);

        //necesito pasarle al adapter el set de datos armado
        CargarRecycle();

        //Listener
        textTituloCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GUARDO EN UNA VARIABLE Drawable la imagen
                //ENVIARLE EL MENSAJE AL ACTIVITY
                notificadorPelicula.abrirGrilla(categoriaACargar);
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            notificadorPelicula = (NotificadorPelicula) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(
                    context.toString() + " implementar NotificarPelicula");
        }

    }


   /* public void onAttachToParentFragment(Fragment fragment) {
        try
        {
            notificadorEntreFragment = (NotificarEntreFragment) fragment;

        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(
                    fragment.toString() + " Implementar NotificarEntreFragments");
        }
    }
    */

    private void CargarRecycle() {
        adapter = new PeliculaAdapter(categoriaACargar.getCategoria().getPeliculas(), this);
        //el layout manager es la disposicion visual del recycler (lineal o grilla, con orientacion vertical u horizontal)
        if (!categoriaACargar.getGrillaActiva()) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL, false));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        }
        //si le puse match parent al alto y ancho del recycler, el setHasFixedSize mejora la performance
        recyclerView.setHasFixedSize(true);
        //le seteo el adapter creado al recycler view
        recyclerView.setAdapter(adapter);
    }


    private void cargarContainer(CategoriaRecycleViewFragment categoriaACargar, TextView textTituloCategoria ){

     String tituloCategoria = categoriaACargar.getCategoria().getNombreCategoria();
     textTituloCategoria.setText(tituloCategoria);
    }


    private CategoriaRecycleViewFragment recibirCategoriaACargar(View view) {//Eugenio Recibo bundle
        Bundle bundle = getArguments();
        String tituloCategoria;
        CategoriaRecycleViewFragment categoriaACargar = new CategoriaRecycleViewFragment();
        if (bundle != null) {
            categoriaACargar = (CategoriaRecycleViewFragment) bundle.getSerializable(CLAVE_CATEGORIA);
        }
        return categoriaACargar;
    }


    public void actualizarPelicula(Pelicula pelicula){
        if(categoriaACargar.getCategoria().getPeliculas().contains(pelicula)){
            adapter.actualizarPelicula(pelicula);
        }
    }
//SETERS AND GETTERS

    ArrayList<Pelicula> getListadoPeliculas(){
        return categoriaACargar.getCategoria().getPeliculas();
    }


    //Imlementación de la interfaz que se comunica con la celda
    @Override
    public void notificarPeliculaClickeado(Pelicula pelicula) {
        //esto se va a llamar cuando se clickee una celda en el adapter
        //Esto hace de pasa mano, y tiene que notificarle al activity el pelicula que llegó.
        //aca estoy en el metodo que me obligo a implementar LA INTERFAZ DEL ADAPTER!
        notificadorPelicula.notificar(pelicula);

    }
    @Override
    public void solicitudDeActualizacionAdapters(Pelicula pelicula) {
        adapter.notifyDataSetChanged();
        notificadorPelicula.solicituddeActualizarDatosFragmentsPelicula(pelicula);

    }




    //INTERFAZ QUE COMUNICA FRAGMENT CON ACTIVITY. EL ACTIVITY ES QUIEN IMPLEMENTA ESTA INTERFAZ
    public interface NotificadorPelicula {
        public void notificar(Pelicula pelicula);
        public void abrirGrilla(CategoriaRecycleViewFragment categoria);
        public void solicituddeActualizarDatosFragmentsPelicula(Pelicula pelicula);



    }
    // INTERFAZ QUE COMUNICA FRAGMENT HIJO (ESTE) CON EL PADRE (EL CONTENEDOR DE TODAS LAS CATEGORIAS)
    public interface NotificarEntreFragment {

    }

}
