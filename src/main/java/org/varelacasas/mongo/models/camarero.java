package org.varelacasas.mongo.models;

import org.bson.types.ObjectId;

public class camarero {

    private ObjectId id;
    private String nombre;

    public camarero(){}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
