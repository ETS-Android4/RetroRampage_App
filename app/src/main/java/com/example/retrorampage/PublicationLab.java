//Asocio el paquete a la clase
package com.example.retrorampage;

//Importo las librerias necesarias
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.retrorampage.database.CursorDabase;
import com.example.retrorampage.database.DatabaseStructure;
import com.example.retrorampage.database.ManagerDatabase;

import java.util.ArrayList;
import java.util.List;

//Declaro una clase para administrar las publications
public class PublicationLab {

    //Declaro un PublicationLab estatico
    private static PublicationLab publicationLab;

    //Declaro un context
    private Context context;

    //Declaro una DB
    private SQLiteDatabase m_Database;

    //Defino un contexto
    private PublicationLab(Context context){

        //
        this.context = context.getApplicationContext();

        //Abrimos la DB, al ser la primera vez se genera y la actualiza si es necesario
        this.m_Database = new ManagerDatabase(this.context).getWritableDatabase();

        if(this.m_Database == null){

        }

    }

    //Metodo para obtener un crimelab con un nuevo context
    public static PublicationLab get(Context context){
        publicationLab = publicationLab == null ? new PublicationLab(context) : publicationLab;
        return publicationLab;
    }

    //
    public List<Publication> getPublications(){

        //
        List<Publication> publicationList = new ArrayList<>();

        //
        CursorDabase cursor = queryPublications(null,null);

        //
        return publicationList;

    }

    //
    private CursorDabase queryPublications(String whereClause, String[] whereArgs){

        //
        Cursor cursor = this.m_Database.query(
                DatabaseStructure.PublicationTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null

        );

        //
        return new CursorDabase(cursor);

    }

}
