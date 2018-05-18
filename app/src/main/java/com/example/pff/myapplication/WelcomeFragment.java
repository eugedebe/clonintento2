package com.example.pff.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class WelcomeFragment extends Fragment {
    public static final String CLAVE_TITULO = "clave titulo";
    public static final String CLAVE_DESCRIPCION = "clave descripcion";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // INFLO LA VISTA DEL LAYOUT
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        // RECIBO EL BUNDLE
        Bundle bundle = getArguments();

        // CARGO EL TEXTVIEW CON EL MESAJE
        TextView textView1 = (TextView) view.findViewById(R.id.textview_welcome2);
        String titulo = bundle.getString("titulo");
        textView1.setText(titulo);

        TextView textView = (TextView) view.findViewById(R.id.textview_welcome);
        String descripcion = bundle.getString("descripcion");
        textView.setText(descripcion);

        ImageView imageView = (ImageView) view.findViewById(R.id.afiche);
        int afiche = bundle.getInt("afiche");
        imageView.setImageResource(afiche);

        //DEVUELO LA VISTA
        return view;
    }
}
