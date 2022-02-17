//Asocio la clase al paquete
package com.example.retrorampage;

//Importo las librerias necesarias
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

//Declaro la clase y heredo de fragment
public class BaseActivity extends AppCompatActivity {

    //Defino el metodo que se ejecuta segun el ciclo de vida del fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Asocio a la activity el viewpager
        setContentView(R.layout.activity_publication_recycler_view);

        //Obtengo el fragmentmanager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Asociamos el fragment con el fragment manager y su ID
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_publication_view_pager);

        //Si el fragment esta vacio accedemos
        if(fragment == null){



        }

    }

}