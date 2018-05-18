package com.example.pff.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class BlankFragment extends Fragment {
    private NotificadorAActivities notificador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        ImageView imageView1 = (ImageView) view.findViewById(R.id.peli1);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.peli2);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.peli3);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.peli4);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula pelicula1 = new Pelicula("Batman - El caballero de la noche",
                        R.drawable.caballero2, "Acción, Crimen, Drama");
                String tituloAMandar = pelicula1.getTitulo();
                String descripcionAMandar = pelicula1.getDescripcion();
                int afiche = pelicula1.getIdAfiche();
                String mensaje = tituloAMandar.toString();
                String descripcion = descripcionAMandar.toString();
                notificador.recibirMensaje(mensaje, descripcion, afiche);
                //String mensaje = tituloAMandar.toString()+ ". " + descripcionAMandar.toString();
                //notificador.recibirMensaje(mensaje);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula pelicula2 = new Pelicula("El Padrino",
                        R.drawable.padrino, "Crimen, Drama");
                String tituloAMandar = pelicula2.getTitulo();
                String descripcionAMandar = pelicula2.getDescripcion();
                int afiche = pelicula2.getIdAfiche();
                String mensaje = tituloAMandar.toString();
                String descripcion =descripcionAMandar.toString();
                notificador.recibirMensaje(mensaje, descripcion, afiche);

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula pelicula3 = new Pelicula("Tiempos Violentos",
                        R.drawable.pulp, "Acción, Crimen, Drama");
                String tituloAMandar = pelicula3.getTitulo();
                String descripcionAMandar = pelicula3.getDescripcion();
                int afiche = pelicula3.getIdAfiche();
                String mensaje = tituloAMandar.toString();
                String descripcion = descripcionAMandar.toString();
                notificador.recibirMensaje(mensaje, descripcion, afiche);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula pelicula1 = new Pelicula("Batman - El caballero de la noche",
                        R.drawable.caballero2, "Crimen, Drama");
                String tituloAMandar = pelicula1.getTitulo();
                String descripcionAMandar = pelicula1.getDescripcion();
                int afiche = pelicula1.getIdAfiche();
                String mensaje = tituloAMandar.toString();
                String descripcion= descripcionAMandar.toString();
                notificador.recibirMensaje(mensaje,descripcion, afiche);
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
    // PASO 3.1
    public interface NotificadorAActivities{

        //ESTE METODO ES EL QUE PERMITIRÁ ENVIARLE EL MENSAJE AL ACTIVITY.
        public void recibirMensaje(String mensaje, String descripcion, int afiche);
    }

}
