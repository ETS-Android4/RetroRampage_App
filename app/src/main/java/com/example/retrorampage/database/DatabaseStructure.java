//Asocio la clase al paquete
package com.example.retrorampage.database;

//Declaro la clase de la base de datos
public class DatabaseStructure {

    //Declaro una clase que sera un tipo de tabla
    public static class PublicationTable{

        //Instancio el nombre de la tabla
        public static final String NAME = "publications";

        //Declaro las columnas de la tabla
        public static final class Cols{

            //Defino los nombres de los atributos de la clase
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String LIKES = "likes";
            public static final String IMG = "imageID";

        }

    }

}
