//Asocio la clase al paquete
package com.example.retrorampage;

//Importo las librerias necesarias
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

//Declaro la clase y heredo de fragment
public class BaseActivity extends AppCompatActivity{

    //Declaro los widget necesarios
    private ImageButton m_ReturnButton;
    private ImageButton m_RankingButton;

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

        //
        setContentView(R.layout.activity_publication_recycler_view);

        //Obtengo el fragmentmanager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Asociamos el fragment con el fragment manager y su ID
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_publication_view_pager);

        //Si el fragment esta vacio accedemos
        if(fragment == null){

            //
            fragment = new PublicationFragment();

            //
            serializeWidgets();

        }

    }

    //
    private void serializeWidgets(){

        //
        this.m_RankingButton = (ImageButton) findViewById(R.id.ranking_button);
        this.m_ReturnButton = (ImageButton) findViewById(R.id.return_button);

        //
        this.m_RankingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //
                m_ReturnButton.setVisibility(View.VISIBLE);
                m_RankingButton.setVisibility(View.INVISIBLE);

            }

        });

        //
        this.m_ReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //
                m_RankingButton.setVisibility(View.VISIBLE);
                m_ReturnButton.setVisibility(View.INVISIBLE);

            }

        });

    }

}