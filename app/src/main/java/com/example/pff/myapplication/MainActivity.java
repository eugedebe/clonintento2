package com.example.pff.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        Fragment1.NotificadorAActivities {


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CARGAR EL FRAGMENT 1

        //CREO UNA INSTANCIA DEL FRAGMENT 1
        Fragment1 fragment1 = new Fragment1();

        //PIDO UN FRAGMENT MANAGER
        FragmentManager manager = getSupportFragmentManager();

        //PIDO UNA TRANSACCION AL FRAGMENT MANAGER
        FragmentTransaction transaction = manager.beginTransaction();

        //LE PIDO A LA TRANSACCION QUE AGREGUE EL FRAGMENT AL CONTENEDOR
        transaction.add(R.id.contenedorFragment, fragment1);

        //CONFIRMO LA TRANSACCIÓN
        transaction.commit();
    }

    //  LA ACTIVITY TIENE QUE SOBREESCRIBIR ESTE METODO PORQUE IMPLEMENTA
    // LA INTERFAZ NOTIFICADORDEACTIVITY
    // ESTE METODO ES EL QUE VA A RECIBIR EL MENSAJE QUE LE ENVIE EL FRAGMENT.
    public void recibirMensaje(String titulo, String descripcion, int afiche){

            //IR A LA SECOND ACTIVITY Y ENVIARLE EL MENSAJE
        Intent unIntent = new Intent(this, WelcomeActivity.class);

        //CARGO EL BUNDLE PARA ENVIAR AL ACTIVITY
        Bundle unBundle = new Bundle();
        //unBundle.putString("mensaje", mensaje);
        unBundle.putString("titulo", titulo);
        unBundle.putString("descripcion", descripcion);
        unBundle.putInt("afiche", afiche);


        //ASOCIO EL BUNDLE AL INTENT
        unIntent.putExtras(unBundle);

        //COMIENZO LA ACTIVIDAD
        startActivity(unIntent);
    }


}
