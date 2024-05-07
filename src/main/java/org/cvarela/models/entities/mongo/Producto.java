package org.cvarela.models.entities.mongo;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Producto {

    private ObjectId id;
    @BsonProperty(value = "nombre")
    private String nombreProducto;
    private float precio;

    public Producto(){}

    public Producto(String nombreProducto, float precio) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
