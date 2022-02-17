//Asocio la clase al paquete
package com.example.retrorampage.database;

//Importo las librerias necesarias
import android.content.Context;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.retrorampage.database.DatabaseStructure;

//Declaro la clase y heredo un clase para administrar nuestra DB
public class ManagerDatabase extends SQLiteOpenHelper {

    //Instancio la version de la DB
    private static final int VERSION = 1;

    //Instancio el nombre de la DB
    private static final String DATABASE_NAME="publications.db";

    //Defino un constructor propio
    public ManagerDatabase(Context context){
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
                DatabaseStructure.PublicationTable.Cols.UUID + ","+
                DatabaseStructure.PublicationTable.Cols.NAME + ","+
                DatabaseStructure.PublicationTable.Cols.LIKES + ","+
                DatabaseStructure.PublicationTable.Cols.IMG + ")"

        );

    }

    //Metodo que se encarga de definir el comportamiento de la DB al actualizarse
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

}
