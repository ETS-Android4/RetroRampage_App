//Asocio la clase al paquete
package com.example.retrorampage.database;

//Importo las librerias necesarias
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.retrorampage.PublicationPOJO;
import com.example.retrorampage.R;
import java.util.UUID;

//Declaro la clase y heredo un clase para administrar nuestra DB
public class ManagerDatabase extends SQLiteOpenHelper {

    //Instancio la version de la DB
    private static final int VERSION = 1;

    //Instancio el nombre de la DB
    private static final String DATABASE_NAME = "publications.db";

    //Array de publicaciones para introducir la informacion inicial
    private final PublicationPOJO[] initialPublications = new PublicationPOJO[]{
            new PublicationPOJO(UUID.randomUUID(), (int) (Math.random() * (100) + 1), R.drawable.retro, "Retro"),
            new PublicationPOJO(UUID.randomUUID(), (int) (Math.random() * (100) + 1), R.drawable.building, "Building"),
            new PublicationPOJO(UUID.randomUUID(), (int) (Math.random() * (100) + 1), R.drawable.fuel, "Fuel Station"),
            new PublicationPOJO(UUID.randomUUID(), (int) (Math.random() * (100) + 1), R.drawable.coffee, "Pub"),
            new PublicationPOJO(UUID.randomUUID(), (int) (Math.random() * (100) + 1), R.drawable.hangar, "Workshop"),
            new PublicationPOJO(UUID.randomUUID(), (int) (Math.random() * (100) + 1), R.drawable.marble, "House"),
            new PublicationPOJO(UUID.randomUUID(), (int) (Math.random() * (100) + 1), R.drawable.planet, "Planet Arcade"),
            new PublicationPOJO(UUID.randomUUID(), (int) (Math.random() * (100) + 1), R.drawable.stage, "Countryside"),
            new PublicationPOJO(UUID.randomUUID(), (int) (Math.random() * (100) + 1), R.drawable.rocket, "Rocket"),
            new PublicationPOJO(UUID.randomUUID(), (int) (Math.random() * (100) + 1), R.drawable.hotel, "Hotel")
    };

    //Defino un constructor propio
    public ManagerDatabase(Context context) {
        super(context,
                DATABASE_NAME,
                null,
                VERSION);
    }

    //Defino el metodo heredado que se ejecuta al crear la DB
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Creo la db mediante el uso de execSQL, defino un ID que se incrementa
        sqLiteDatabase.execSQL("create table " + DatabaseStructure.PublicationTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                DatabaseStructure.PublicationTable.Cols.UUID + "," +
                DatabaseStructure.PublicationTable.Cols.NAME + "," +
                DatabaseStructure.PublicationTable.Cols.LIKES + "," +
                DatabaseStructure.PublicationTable.Cols.IMG + ")"

        );

        //Insertamos todos las publicaciones
        for (int i = 0; i < this.initialPublications.length; i++) {
            insertInitialPublications(this.initialPublications[i], sqLiteDatabase);
        }

    }

    //Metodo para inserta una publicacion en una DB
    private void insertInitialPublications(PublicationPOJO publication, SQLiteDatabase sqLiteDatabase) {

        //Sentencia que inserta informacion en la tabla
        sqLiteDatabase.execSQL("insert into " + DatabaseStructure.PublicationTable.NAME + "(" +
                DatabaseStructure.PublicationTable.Cols.UUID + "," +
                DatabaseStructure.PublicationTable.Cols.NAME + "," +
                DatabaseStructure.PublicationTable.Cols.LIKES + "," +
                DatabaseStructure.PublicationTable.Cols.IMG + ")" +

                "values('" + publication.getPublicationID().toString() + "','" +
                publication.getName() + "','" +
                publication.getLikesNumber() + "','" +
                publication.getImageID() + "')");

    }

    //Metodo que se encarga de definir el comportamiento de la DB al actualizarse
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

}
