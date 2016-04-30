package com.example.android.morse;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.os.Handler;

/**
 * Created by Ariel on 29/04/2016.
 */
public class splash extends Activity {

    // Temporizador para la pantalla de bienvenida
    private static int SPLASH_TIEMPO = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {

			/*
			* Mostramos la pantalla de bienvenida con un temporizador.
			* De esta forma se puede mostrar el logo de la app o
			* compañia durante unos segundos.
			*/

            @Override
            public void run() {
                // Este método se ejecuta cuando se consume el tiempo del temporizador.
                // Se pasa a la activity principal
                Intent i = new Intent(splash.this, MainActivity.class);
                startActivity(i);

                // Cerramos esta activity
                finish();
            }
        }, SPLASH_TIEMPO);
    }

}