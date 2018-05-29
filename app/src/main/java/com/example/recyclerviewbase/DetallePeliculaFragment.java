package com.example.recyclerviewbase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetallePeliculaFragment extends Fragment {

    public static final String PELICULA_KEY = "Pelicula_key";
    private ImageView imagenPelicula;
    private TextView tituloPelicula;
    private TextView descripcionPelicula;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_pelicula, container, false);
        imagenPelicula = view.findViewById(R.id.imagen_pelicula);
        tituloPelicula = view.findViewById(R.id.titulo_pelicula);
        descripcionPelicula = view.findViewById(R.id.descripcion_pelicula);

        Bundle bundle = getArguments();
        Pelicula pelicula = (Pelicula) bundle.getSerializable(PELICULA_KEY);
        tituloPelicula.setText(pelicula.getNombre());
        descripcionPelicula.setText(pelicula.getDescripcion());
        imagenPelicula.setImageResource(pelicula.getImageRes());


        return view;
    }

}
