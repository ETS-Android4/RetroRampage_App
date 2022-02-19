//Asocio el paquete a la clase
package com.example.retrorampage;

//Importo las librerias necesarias
import android.content.ContentValues;
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
    private PublicationLab(Context context) {

        //Obtengo el contexto de la DB
        this.context = context.getApplicationContext();

        //Abrimos la DB, al ser la primera vez se genera y la actualiza si es necesario
        this.m_Database = new ManagerDatabase(this.context).getWritableDatabase();

    }

    //Metodo para obtener un crimelab con un nuevo context
    public static PublicationLab get(Context context) {
        publicationLab = publicationLab == null ? new PublicationLab(context) : publicationLab;
        return publicationLab;
    }

    //Metodo que devuelve una lista
    public List<Publication> getPublications() {

        //Instancio una lista vacia
        List<Publication> publicationList = new ArrayList<>();

        //Obtengo el cursor asociado a la tabla
        CursorDabase cursor = queryPublications(null, null);

        try {

            //Desplazo el cursor al comienzo
            cursor.moveToFirst();

            //Mientras el cursor no este al final ejecutamos el bucle
            while (!cursor.isAfterLast()) {

                //Añadimos a la lista la publicacion obtenida del cursor
                publicationList.add(cursor.getPublication());

                //Desplazamos el cursor
                cursor.moveToNext();

            }

        } finally {

            //Cierro el cursor
            cursor.close();

        }

        //Devolvemos la lista
        return publicationList;

    }

    //Metodo para actualizar los datos de la publicacion
    public void updatePublication(Publication publication) {

        //Llamamos al metodo actualizar de la BD
        this.m_Database.update(
                DatabaseStructure.PublicationTable.NAME,                        //Nombre de la tabla
                getContentValues(publication),                                  //Valores de la publication
                DatabaseStructure.PublicationTable.Cols.UUID + "= ?", //Condicion
                new String[]{publication.getPublicationID().toString()});       //UUID de la publicacion

    }

    //Metodo que devuelve un cursor asociado a la tabla
    private CursorDabase queryPublications(String whereClause, String[] whereArgs) {

        //Declaro un cursor y lo asocio a la tabla
        Cursor cursor = this.m_Database.query(
                DatabaseStructure.PublicationTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null

        );

        //Devuelvo el cursor
        return new CursorDabase(cursor);

    }

    //Metodo para transformar una publication a un formato contentvalues
    private static ContentValues getContentValues(Publication publication) {

        //Instancio un content de valores
        ContentValues values = new ContentValues();

        //Añado todos los valores de la publicacion
        values.put(DatabaseStructure.PublicationTable.Cols.UUID, publication.getPublicationID().toString());
        values.put(DatabaseStructure.PublicationTable.Cols.NAME, publication.getName());
        values.put(DatabaseStructure.PublicationTable.Cols.IMG, publication.getImageID());
        values.put(DatabaseStructure.PublicationTable.Cols.LIKES, publication.getLikesNumber());
        return values;

    }

}
