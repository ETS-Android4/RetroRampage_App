//Asociamos la clase al paquete
package com.example.retrorampage.database;

//Importamos las librerias necesarias
import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.retrorampage.PublicationPOJO;
import java.util.UUID;

//Defino la clase y heredo, esta clase sirve para usar el cursor
public class CursorDabase extends CursorWrapper {

    //Defino un constructor con el cursor
    public CursorDabase(Cursor cursor) {
        super(cursor);
    }

    //Metodo que devolvera una publicacion con datos mediante el cursor
    public PublicationPOJO getPublication() {
        return new PublicationPOJO(
                UUID.fromString(getString(getColumnIndex(DatabaseStructure.PublicationTable.Cols.UUID))),
                getLong(getColumnIndex(DatabaseStructure.PublicationTable.Cols.LIKES)),
                getLong(getColumnIndex(DatabaseStructure.PublicationTable.Cols.IMG)),
                getString(getColumnIndex(DatabaseStructure.PublicationTable.Cols.NAME)));
    }

}
