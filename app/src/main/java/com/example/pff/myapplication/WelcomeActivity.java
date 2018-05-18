package com.example.pff.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        //RECIBIR EL BUNDLE
        Intent unIntent = getIntent();
        Bundle unBundle = unIntent.getExtras();

        //CARGAR EL FRAGMENT 2
        WelcomeFragment welcomeFragment = new WelcomeFragment();


        //LE ENVIO EL BUNDLE AL FRAGMENT
        welcomeFragment.setArguments(unBundle);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.contenedorFragment2, welcomeFragment);
        transaction.commit();
    }
}
