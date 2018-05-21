package com.example.pff.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment1 extends Fragment {
    private NotificadorAActivities notificador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        ImageView imageView1 = (ImageView) view.findViewById(R.id.peli1);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.peli2);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.peli3);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.peli4);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula pelicula1 = new Pelicula("Batman - El caballero de la noche",
                        "Acción, Crimen, Drama", R.drawable.caballero2);
                String titulo = pelicula1.getTitulo();
                String descripcion = pelicula1.getDescripcion();
                int afiche = pelicula1.getIdAfiche();
                notificador.recibirMensaje(titulo, descripcion, afiche);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula pelicula2 = new Pelicula("El Padrino",
                         "Crimen, Drama",R.drawable.padrino);
                String titulo= pelicula2.getTitulo();
                String descripcion = pelicula2.getDescripcion();
                int afiche = pelicula2.getIdAfiche();
                notificador.recibirMensaje(titulo, descripcion, afiche);

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula pelicula3 = new Pelicula("Tiempos Violentos",
                        "Acción, Crimen, Drama", R.drawable.pulp);
                String titulo = pelicula3.getTitulo();
                String descripcion = pelicula3.getDescripcion();
                int afiche = pelicula3.getIdAfiche();
                notificador.recibirMensaje(titulo, descripcion, afiche);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula pelicula1 = new Pelicula("Batman - El caballero de la noche",
                         "Crimen, Drama", R.drawable.caballero2);
                String titulo = pelicula1.getTitulo();
                String descripcion = pelicula1.getDescripcion();
                int afiche = pelicula1.getIdAfiche();
                notificador.recibirMensaje(titulo,descripcion, afiche);
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.notificador = (NotificadorAActivities) context;
        }


    // ESTA INTERFAZ SE CREA PARA PODER COMUNICAR AL FRAGMENT CON EL ACTIVITY QUE LO ESTE USANDO.
    // CON ESTA INTERFAZ, EL FRAGMENT PUEDE SER REUTILIZADO EN CUALQUIER ACTIVITY.
    // EL ACTIVITY QUE USE ESTE FRAGMENT DEBERA IMPLEMENTAR ESTA INTERFAZ.

    public interface NotificadorAActivities{

        //ESTE METODO ES EL QUE PERMITIRÁ ENVIARLE EL MENSAJE AL ACTIVITY.
        public void recibirMensaje(String titulo, String descripcion, int afiche);
    }

}
