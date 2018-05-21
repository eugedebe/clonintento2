package com.example.pff.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class Fragment2 extends Fragment {
    public static final String CLAVE_TITULO = "clave titulo";
    public static final String CLAVE_DESCRIPCION = "clave descripcion";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // INFLO LA VISTA DEL LAYOUT
        View view = inflater.inflate(R.layout.fragment2, container, false);

        // RECIBO EL BUNDLE
        Bundle bundle = getArguments();

        //CREO LA PELICULA QUE HAN MANDADO EN EL BUNDLE
        Pelicula peliculaRecibida = new Pelicula (bundle.getString("titulo"),
                bundle.getString("descripcion"),
                bundle.getInt("afiche"));

        //CARGO LA PELICULA RECIBIDA EN LOS TEXTVIEW Y EN EL IMAGEVIEW DEL FRAGMENT

        TextView textView2 = (TextView) view.findViewById(R.id.textview_welcome_titulo);
        textView2.setText(peliculaRecibida.getTitulo());

        TextView textView3 = (TextView) view.findViewById(R.id.textview_welcome_descripcion);
        textView3.setText(peliculaRecibida.getDescripcion());

        ImageView imageView1 = (ImageView) view.findViewById(R.id.afiche);
        imageView1.setImageResource(peliculaRecibida.getIdAfiche());

        //DEVUELO LA VISTA
        return view;
    }
}
