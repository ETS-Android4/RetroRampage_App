//Asocio la clase al paquete
package com.example.retrorampage;

//Importo las librerias necesarias
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

//Declaro la clase y heredo de fragment
public class BaseActivity extends AppCompatActivity{

    //Defino el metodo que se ejecuta segun el ciclo de vida del fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //El sistema incluye funciones de ventana completa
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Asociamos (flags) características para esta windows
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Asocio a la view un layout
        setContentView(R.layout.activity_publication_base);

        //Instacio el fragment
        instanceFragment();

    }

    //Metodo para instanciar el fragment
    private void instanceFragment(){

        //Obtengo el fragmentmanager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Asociamos el fragment con el fragment manager y su ID
        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_base_publication);

        //Si el fragment esta vacio accedemos
        if(fragment == null){

            //Instancio un fragment
            fragment = new PublicationFragment();
            fragmentManager.beginTransaction().add(R.id.activity_base_publication,fragment).commit();

        }

    }

}