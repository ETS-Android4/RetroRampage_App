//Asocio la clase al paquete
package com.example.retrorampage;

//Importo las librerias necesarias
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//Declaro la clase y heredo de fragment
public class PublicationFragment extends Fragment {

    //Declaro los widget necesarios
    private ImageButton m_ReturnButton;
    private ImageButton m_RankingButton;

    //Declaro nuestro recyclerview y adapter
    private RecyclerView m_RecyclerView;
    private PublicationAdapter m_Adapter;

    //Metodo para definir nuestra UI
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Adjunta las vistas a su padre, cualquier evento táctil que reciban las vistas se transferirá a la principal
        View view = inflater.inflate(R.layout.fragment_publication_recycler_view,container,false);

        //Serializo los elementos de la toolbar
        serializeWidgets();

        //Instancio un publicationLab con un nuevo context
        PublicationLab publicationLab = PublicationLab.get(getActivity());

        //Obtengo la lista mediante el lab
        List<Publication> publicationsList = publicationLab.getPublications();

        //Serializo una recycleview
        this.m_RecyclerView = (RecyclerView) view.findViewById(R.id.fragment_publication_view_pager);

        //Indico la forma en la que se situan los elementos en pantalla
        this.m_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Instancio un adapater con una lista
        this.m_Adapter = new PublicationAdapter(publicationsList);

        //Asocio el adapter a la recyclerview
        this.m_RecyclerView.setAdapter(this.m_Adapter);
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

    //Clase que sirve para definir cada view de cada publicacion con su contenido
    private class PublicationHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //Declaro los widget de la clase
        private ImageView m_ImagePublication;
        private TextView m_TitlePublication;
        private ImageButton m_LikeButton;
        private TextView m_LikeNumber;
        private Publication publication;

        //Definimos un constructor en el que asociamos una vista
        public PublicationHolder(@NonNull View itemView) {
            super(itemView);
        }

        //Defino el constructor donde asocio el layout y sus elementos a la view
        public PublicationHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.fragment_publication, parent, false));

            //Serializo los componentes
            this.m_ImagePublication = itemView.findViewById(R.id.image_view_fragment);
            this.m_LikeButton = itemView.findViewById(R.id.like_button_id);
            this.m_LikeNumber = itemView.findViewById(R.id.like_number_id);
            this.m_TitlePublication = itemView.findViewById(R.id.title_image_id);

            //Asociamos a esta view un listener
            itemView.setOnClickListener((View.OnClickListener) this.m_LikeButton);

        }

        //Metodo para actualizar el fragment actual y sus atributos
        public void bind(Publication publication){

            //Obtengo la informacion de la publicacion y actualizo los widget
            this.publication = publication;
            this.m_TitlePublication.setText(this.publication.getName());
            this.m_LikeNumber.setText((int)this.publication.getLikesNumber());
            this.m_ImagePublication.setImageResource((int)this.publication.getImageID());

        }

        //Metodo que define el comportamiento de cada view
        @Override
        public void onClick(View view) {

            Toast.makeText(getActivity(), "LIKE!", Toast.LENGTH_LONG).show();

        }

    }

    //Declaro una clase, heredamos de adapter y lo asociamos al holder
    private class PublicationAdapter extends RecyclerView.Adapter<PublicationHolder>{

        //Definimos una lista de publications
        private List<Publication> publicationsList;

        //Definimos el constructor que instancia una lista
        public PublicationAdapter(List<Publication>publications){this.publicationsList = publications;}

        //Definimos el constructor
        @NonNull
        @Override
        public PublicationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            //Instanciamos un layout xml y obtenemos el de la activity
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            //Instaciamos un publication holder con el layout y el contenedor de vistas
            return new PublicationHolder(layoutInflater,parent);

        }

        //Metodo que actualiza conforme nos desplazamos por la lista
        @Override
        public void onBindViewHolder(@NonNull PublicationHolder holder, int position) {

            //Obtenemos una publication de la lista segun la posicion y actualizamos
            holder.bind(this.publicationsList.get(position));

        }

        //Devolvemos el tamaño de la lista
        @Override
        public int getItemCount() {
            return this.publicationsList.size();
        }

    }

}
