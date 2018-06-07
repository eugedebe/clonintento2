package com.example.recyclerviewbase;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetallePeliculaFragment extends Fragment {

    public static final String PELICULA_KEY = "Pelicula_key";
    public static final String NOMBRE_CATEGORIA_KEY = "Categoria";

    public DetallePeliculaFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_pelicula, container, false);
        ImageView IVimagenPelicula =  (ImageView) view.findViewById(R.id.imagen_pelicula);
        TextView TVtituloPelicula = (TextView) view.findViewById(R.id.titulo_pelicula);
        TextView TVdescripcionPelicula = (TextView) view.findViewById(R.id.descripcion_pelicula);
        TextView TVnombreCategoria = (TextView) view.findViewById(R.id.titulo_categoria);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.relative) ;

        Bundle bundle = getArguments();
        Pelicula pelicula = (Pelicula) bundle.getSerializable(PELICULA_KEY);
        String nombreCategoria = (String) bundle.getString(NOMBRE_CATEGORIA_KEY);
        TVtituloPelicula.setText(pelicula.getNombre());
        TVdescripcionPelicula.setText(pelicula.getDescripcion());
        IVimagenPelicula.setImageResource(pelicula.getImageRes());
        TVnombreCategoria.setText(nombreCategoria);

        return view;
    }


    public static DetallePeliculaFragment DameUnFragmentDetallePelicula (Pelicula pelicula,String nombreCategoria){
        //Esta es la fábrica de fragments. Se invocará sin instanciar la clase por ser static

        //Genero un nuevo fragment concreto. Que este método retornará.
        DetallePeliculaFragment detallePeliculaFragment = new DetallePeliculaFragment();

        //Genero un bundle para poblar el fragment concreto con sus datos
        Bundle bundle = new Bundle();
        bundle.putSerializable(PELICULA_KEY, pelicula);
        bundle.putString(NOMBRE_CATEGORIA_KEY,nombreCategoria);

        detallePeliculaFragment.setArguments(bundle);
        //Devuelvo el fragment ya con título y con su bundle
        return detallePeliculaFragment;
    }
}
