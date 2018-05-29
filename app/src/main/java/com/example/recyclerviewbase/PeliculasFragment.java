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
    //private List<Pelicula> peliculas;
    private ArrayList<Pelicula> peliculas;
    private NotificadorPelicula notificadorPelicula;
    private PeliculaAdapter adapter;
    public static final String CLAVE_TITULO_CATEGORIA = "titulo_categoria";
    public static final String CLAVE_ACTIVAR_GRILLA = "estado_grilla";
    public static final String CLAVE_PELICULAS = "clave_peliculas";
    TextView textTituloCategoria;
    Boolean estadoGrilla;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        estadoGrilla=false;
        View view = inflater.inflate(R.layout.fragment_peliculas, container, false);

        recyclerView = view.findViewById(R.id.recycler_id);

        recibirParametro(view);
        //  armarListadoPeliculas();
        //necesito pasarle al adapter el set de datos armado

        adapter = new PeliculaAdapter(peliculas, this);



        textTituloCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GUARDO EN UNA VARIABLE Drawable la imagen
                //ENVIARLE EL MENSAJE AL ACTIVITY
                notificadorPelicula.abrirGrilla(textTituloCategoria.getText().toString(),peliculas);
            }
        });




        //el layout manager es la disposicion visual del recycler (lineal o grilla, con orientacion vertical u horizontal)
        if(!estadoGrilla) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL, false));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        }
        //si le puse match parent al alto y ancho del recycler, el setHasFixedSize mejora la performance
        recyclerView.setHasFixedSize(true);
        //le seteo el adapter creado al recycler view
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificadorPelicula = (NotificadorPelicula) context;

    }

    private void recibirParametro(View view) {//Eugenio Recibo bundle
        Bundle bundle = getArguments();
        String tituloCategoria;
        if (bundle != null) {
            tituloCategoria = bundle.getString(CLAVE_TITULO_CATEGORIA);
            estadoGrilla = bundle.getBoolean(CLAVE_ACTIVAR_GRILLA);
            peliculas = (ArrayList) bundle.getSerializable(CLAVE_PELICULAS);
            textTituloCategoria = (TextView) view.findViewById(R.id.nombreCategoria);
            textTituloCategoria.setText(tituloCategoria);
        }
    }

    public void actualizarPelicula(Pelicula pelicula){
        if(peliculas.contains(pelicula)){
            adapter.actualizarPelicula(pelicula);
        }
    }


    /*private void armarListadoPeliculas() {
        peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("Batman - El Caballero Oscuro",
                "Acción, Drama, Crimen", R.drawable.caballero2));
        peliculas.add(new Pelicula("El Padrino",
                "Crimen, Drama", R.drawable.padrino));
        peliculas.add(new Pelicula("Tiempos Violentos",
                "Accion, Drama, Crimen", R.drawable.pulp));
        peliculas.add(new Pelicula("El Profesional",
                "Crimen, Drama", R.drawable.elprofesional));
        peliculas.add(new Pelicula("El Señor de los Anillos",
                "Aventura, Fantasia", R.drawable.lordof));
        peliculas.add(new Pelicula("Star Wars",
                "Ciencia Ficción", R.drawable.starwars));
        peliculas.add(new Pelicula("Matrix",
                "Ciencia Ficción", R.drawable.matrix));
        peliculas.add(new Pelicula("Origen",
                "Ciencia Ficción", R.drawable.origen));
        peliculas.add(new Pelicula("Forrest Gump",
                "Drama", R.drawable.forrest));
    }
*/

    @Override
    public void notificarPeliculaClickeado(Pelicula pelicula) {
        //esto se va a llamar cuando se clickee una celda en el adapter
        //Esto hace de pasa mano, y tiene que notificarle al activity el pelicula que llegó.
        //aca estoy en el metodo que me obligo a implementar LA INTERFAZ DEL ADAPTER!
        notificadorPelicula.notificar(pelicula);

    }

    @Override
    public void solicitudDeActualizacionAdapters(Pelicula pelicula) {
        notificadorPelicula.solicituddeActualizarDatosFragmentsPelicula(pelicula);

    }


    //INTERFAZ QUE COMUNICA FRAGMENT CON ACTIVITY. EL ACTIVITY ES QUIEN IMPLEMENTA ESTA INTERFAZ
    public interface NotificadorPelicula {
        public void notificar(Pelicula pelicula);
        public void abrirGrilla(String categoria, ArrayList<Pelicula> peliculas);
        public void solicituddeActualizarDatosFragmentsPelicula(Pelicula pelicula);

    }


}
