//Asocio la clase al paquete
package com.example.retrorampage;

//Importo las librerias necesarias
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

//Declaro la clase y heredo de fragment
public class PublicationFragment extends Fragment {

    //Declaro los widget necesarios
    private ImageButton m_ReturnButton;
    private ImageButton m_RankingButton;

    //Declaro nuestro recyclerview
    private RecyclerView m_RecyclerView;

    //Defino el metodo que se ejecuta segun el ciclo de vida del fragment
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    //Metodo para definir nuestra UI
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Adjunta las vistas a su padre, cualquier evento táctil que reciban las vistas se transferirá a la principal
        View view = inflater.inflate(R.layout.fragment_publication,container,false);

        //Serializo los elementos
        serializeWidgets();
        return view;

    }

    //Metodo para serializar widget y darles un comportamiento
    private void serializeWidgets(){

        //Serilializo los widget mediante la activity que posee sus ID
        this.m_RankingButton = (ImageButton) getActivity().findViewById(R.id.ranking_button);
        this.m_ReturnButton = (ImageButton) getActivity().findViewById(R.id.return_button);

        //Defino el comportamiento del ranking button
        this.m_RankingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Hago invible un button y el otro visible
                m_ReturnButton.setVisibility(View.VISIBLE);
                m_RankingButton.setVisibility(View.INVISIBLE);

            }

        });

        //Defino el comportamiento del return button
        this.m_ReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Hago invible un button y el otro visible
                m_RankingButton.setVisibility(View.VISIBLE);
                m_ReturnButton.setVisibility(View.INVISIBLE);

            }

        });

    }

    //Metodo para instaciar el fragment
    public static void newInstance(Context context){

    }

}
