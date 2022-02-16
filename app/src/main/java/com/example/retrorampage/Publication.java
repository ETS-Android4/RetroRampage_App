package com.example.retrorampage;

import java.util.UUID;

//Declaramos la clase que definira nuestro tipo de datos
public class Publication {

    //Defino los atributos de la clase
    private String name;
    private long likesNumber;
    private long imageID;
    private UUID publicationID;

    //Definimos el constructor y su sobrecarga para el cursor
    public Publication(){this (UUID.randomUUID());}
    public Publication(UUID publicationID){this.publicationID = publicationID;}

    //Definimos los get de la clase
    public String getName() {return name;}
    public long getImageID() {return imageID;}
    public long getLikesNumber() {return likesNumber;}
    public UUID getPublicationID() {return publicationID;}

    //Definimos los set  de la clase
    public void setLikesNumber(long likesNumber) {this.likesNumber = likesNumber;}
    public void setImageID(long imageID) {this.imageID = imageID;}
    public void setPublicationID(UUID publicationID) {this.publicationID = publicationID; }
    public void setName(String name) {this.name = name;}

}
