package org.varelacasas.mongo.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class consumicion {

    private ObjectId id;
    @BsonProperty(value = "alumno_id")
    private ObjectId alumnoId;
    @BsonProperty(value = "producto_id")
    private ObjectId productoId;
    private alumno aAlumno;
    private producto aProducto;
    private estadoCobroConsumicion estadoCobro = estadoCobroConsumicion.PENDIENTE;

    public consumicion(){}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(ObjectId alumnoId) {
        this.alumnoId = alumnoId;
    }

    public ObjectId getProductoId() {
        return productoId;
    }

    public void setProductoId(ObjectId productoId) {
        this.productoId = productoId;
    }

    public org.varelacasas.mongo.models.alumno getAlumno() {
        return aAlumno;
    }

    public void setAlumno(org.varelacasas.mongo.models.alumno alumno) {
        this.aAlumno = alumno;
    }

    public org.varelacasas.mongo.models.producto getProducto() {
        return aProducto;
    }

    public void setProducto(org.varelacasas.mongo.models.producto producto) {
        this.aProducto = producto;
    }

    public estadoCobroConsumicion getEstadoCobro() {
        return estadoCobro;
    }

    public void setEstadoCobro(estadoCobroConsumicion estadoCobro) {
        this.estadoCobro = estadoCobro;
    }
}
